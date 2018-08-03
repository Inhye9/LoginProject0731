package LoginTask.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import LoginTask.service.MailingService;

@Controller
public class MailController {

	@Autowired
	MailingService mailingService;

	// 회원가입 축하 메일 전송
	@RequestMapping("/mail/RegiAlertMail")
	public String sendRegiAlertMail(HttpServletRequest request) throws MessagingException, IOException {

		String id = (String) request.getSession(true).getAttribute("id");
		mailingService.sendRegiAlertMail(id);

		return "MailAlert";
	}

	// 회원가입 인증 메일 전송
	@RequestMapping("/mail/RegiConfirmMail/{id}")
	public String sendRegiConfirmMail(@PathVariable("id") String id, HttpServletRequest request)
			throws MessagingException, IOException {

		mailingService.sendRegiConfirmMail(id);

		return "MailAlert";
	}

	// 회원가입 인증메일 클릭 시, Confirm -> 'Yes'로 바꿔주는 메서드
	@RequestMapping("/mail/RegiConfirmingMail/{id}")
	public String sendRegiConfirmingMail(@PathVariable("id") String id, HttpServletRequest request)
			throws MessagingException, IOException {

		mailingService.sendRegiConfirmingMail(id);

		return "ConfirmedMailAlert";
	}

	// 임시 비밀번호 폼으로 보내는 메서드
	@RequestMapping(value="/mail/tempPassword", method=RequestMethod.GET)
	public String sendPasswordForm() {
		return "tempPasswordForm";
	}

	// 임시 비밀번호 데이터 비교 후 메일 발송
	@RequestMapping(value="/mail/tempPassword", method=RequestMethod.POST)
	public String sendConparePassword(@RequestParam("id") String id, 
			@RequestParam("name") String name,
			@RequestParam("email") String email, 
			Model model) throws UnsupportedEncodingException, MessagingException {

		int resultCnt = mailingService.makeTmpPwd(id, name, email);

		model.addAttribute("resultCnt", resultCnt);

		return "tempPasswordAct";
	}

	// 임시 비밀번호로 비밀번호 변경 폼으로 전송
	@RequestMapping(value="/pwd/changePassword", method=RequestMethod.GET)
	public String changePassword() throws UnsupportedEncodingException, MessagingException {
		
		return "changePasswordForm";
	}

	
	//본격 비밀번호를 변경해주는 메서드
	@RequestMapping(value ="/pwd/changePassword", method=RequestMethod.POST)
	public String changePassword(HttpServletRequest request ,@RequestParam("prePw") String prePw, @RequestParam("pwd") String pwd, Model model)
			throws UnsupportedEncodingException, MessagingException {
		boolean result = false;
		String id = (String) request.getSession(true).getAttribute("id");
		result = mailingService.changePwd(id, prePw, pwd);
		
		model.addAttribute("result", result);
		
		return "changePasswordAct";
	}
	


}
