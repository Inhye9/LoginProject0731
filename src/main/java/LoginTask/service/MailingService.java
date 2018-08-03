package LoginTask.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import LoginTask.dao.JoinerInterfaceDao;
import LoginTask.model.Joiner;

public class MailingService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	JoinerInterfaceDao dao;
	
	public void sendRegiAlertMail(String id) throws MessagingException, UnsupportedEncodingException {
		
		Joiner joiner = null;
		
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		joiner = dao.selectOne(id);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
		
		String html="<h2>"+id+"님, 왕건주식회사 회원가입을 진심으로 감사 드립니다</h2><br>"
				+ joiner.getName() +"님 의 회원 가입 정보는 아래와 같습니다<br><br>"
				+ "회원 아이디: " + id+ "<br>"
				+ "회원 이름: " + joiner.getName() + "<br><br>"
				+ "<a href=\'http://localhost/LoginProj/'>홈페이지</a>를 방문하시면 회원정보를 수정할 수 있습니다. <br>";
		
		messageHelper.setSubject("[안내]" + joiner.getName() +  "님 회원가입을 축하드립니다!");
		messageHelper.setText(html, true);
		messageHelper.setFrom("ryuinhye9501@gmail.com", "왕건주식회사");
		messageHelper.setTo(new InternetAddress("ryuinhye95@gmail.com" , joiner.getName(), "utf-8"));
		
		
		mailSender.send(message);
		
		System.out.println("발송완료");
	}
	
	
	
	public void sendRegiConfirmMail(String id) throws MessagingException, UnsupportedEncodingException{
	
		Joiner joiner = null;
		
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		joiner = dao.selectOne(id);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
		
		String html="<h2>"+id+"님, 왕건주식회사 회원가입을 진심으로 감사 드립니다</h2><br>"
				+ joiner.getName() +"님 의 회원 가입 정보는 아래와 같습니다<br><br>"
				+ "회원 아이디: " + id+ "<br>"
				+ "회원 이름: " + joiner.getName() + "<br><br>"
				+ "아래 '인증하기'를 클릭하시면 회원가입이 인증됩니다.<br>"
				+ "<a href=\'http://localhost/LoginProj/mail/RegiConfirmingMail/"+id+"'>인증하기</a><br>";
				/*+ "<input type='button' value='확인하기' onclick='location.href=\'http://localhost/LoginProj/mail/RegiConfirmingMail/"+id+"'>";*/
		
		messageHelper.setSubject("[안내]" + joiner.getName() +  "님 회원가입을 인증해주세요!");
		messageHelper.setText(html, true);
		messageHelper.setFrom("ryuinhye9501@gmail.com", "왕건주식회사");
		messageHelper.setTo(new InternetAddress("ryuinhye95@gmail.com" , joiner.getName(), "utf-8"));
		
		
		mailSender.send(message);
		
		System.out.println("발송완료");
		
	}
	
	
	public void sendRegiConfirmingMail(String id) throws MessagingException, UnsupportedEncodingException{
		
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		dao.updateConfirmbyMail(id);
		
	}
	
	
	//임시 비밀번호 생성
	public int makeTmpPwd(String id, String name, String email) throws MessagingException, UnsupportedEncodingException {
		
		int resultCnt = 0;
		Joiner joiner;
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		
		//id로 데이터 받아옴 
		joiner = dao.selectOne(id);
		
		if(joiner!=null) {
			if(joiner.getName().equals(name)) {
				if(joiner.getEmail().equals(email)) {
					
					//임시 비밀번호 생성
					String pwd = "";
					for(int i=0; i<12; i++) {
						pwd += (char)((Math.random()*26) + 97);
					}
					
					joiner.setPwd(pwd);
					System.out.println(joiner.getPwd());
					dao.updateTempPwd(id, pwd);
					
					
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
					
					String html="<h2>"+id+"님의 임시 비밀번호 입니다.</h2><br>"
							+ "회원 아이디: " + joiner.getId() + "<br>"
							+ "회원 이름: " + joiner.getName() + "<br>"
							+ "<b>임시 비밀번호: " + joiner.getPwd() +"</b><br><br>"
							+ "빠른 시일 안에 비밀번호를 변경해주세요!<br>"
							+ "<a href=\'http://localhost/LoginProj/login/loginForm'>로그인 하러가기</a><br>";
							
					messageHelper.setSubject("[긴급]" + joiner.getName() +  "님의 임시 비밀번호 입니다.");
					messageHelper.setText(html, true);
					messageHelper.setFrom("ryuinhye9501@gmail.com", "왕건주식회사");
					messageHelper.setTo(new InternetAddress("ryuinhye95@gmail.com" , joiner.getName(), "utf-8"));
					
					mailSender.send(message);
					
					resultCnt = 1;
					
				}else {
					resultCnt = 4;
				}
			}else {
				resultCnt = 2;
			}
	
		}else {
			resultCnt = 0;
		}
		
		return resultCnt;
		
	}
	
	
	//본격 비밀번호 변경
	public boolean changePwd(String id, String prePw, String pwd) throws MessagingException, UnsupportedEncodingException {
		
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		Joiner joiner;
		
		boolean resultB = false;
		
		//id로 데이터 받아옴 
		joiner = dao.selectOne(id);
		
		if(joiner!=null) {
			if(joiner.getPwd().equals(prePw)) {
				joiner.setPwd(pwd);
				dao.updateTempPwd(id, pwd);
				
				resultB = true;
			}
		}
		return resultB;
	}
	
}
