package LoginTask.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import LoginTask.dao.JdbcTemplateJoinerDao;
import LoginTask.dao.JoinerDao;
import LoginTask.dao.JoinerInterfaceDao;
import LoginTask.dao.MybatisJoinerDao;
import LoginTask.model.Joiner;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class insertJoinerService {

	/*@Autowired
	JoinerDao dao;*/
	
	/*@Autowired
	JdbcTemplateJoinerDao dao;*/
	
	/*@Autowired
	MybatisJoinerDao dao;*/
	
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	JoinerInterfaceDao dao; //Bean 등록 하지 않기 때문에 @Autowired x. 
	
	//데이터 삽입 메서드_회원가입
	@Transactional
	public int insertJoiner(Joiner joiner, HttpServletRequest request) throws ServiceException, IllegalStateException, IOException, SQLException{
		
		dao = sqlsessionTemplate.getMapper(JoinerInterfaceDao.class);
		
		int resultCnt = 0;
		/*Connection conn = null;*/
		String imgName = "";
		
		/*Multipart 프로필 사진 저장하기*/
		//물리적인 저장
		//1. 저장 경로 설정
		String uploadUri = "/file/photo";
		//2. 시스템의 물리적인 경로 정의 
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		
		System.out.println(dir);
		
		//사용자의 업로드 파일을 물리적으로 저장 
		if(!joiner.getPhotoFile().isEmpty()){
			imgName = joiner.getId() + "_" +joiner.getPhotoFile().getOriginalFilename(); //이미지 중복을 막기위해 Time 메서드를 붙여줌.
			/*System.currentTimeMillis() + joiner.getPhotoFile().getOriginalFilename();*/
			
			//저장 
			joiner.getPhotoFile().transferTo(new File(dir, imgName));
			
			//DB에 저장할 파일 이름을 지정
			joiner.setPhoto(imgName);
			
		}

		
		/*try {*/
			/*conn = ConnectionProvider.getConnection();*/
			/*JoinerDao dao = JoinerDao.getInstance();*/
			
			/*resultCnt = dao.insert(conn, joiner);*/
			/*resultCnt = dao.insert(joiner);*/
			resultCnt = dao.insert(joiner);
			return resultCnt;
			
		/*}finally {
			JdbcUtil.close(conn);
		}*/
	}
	
}
