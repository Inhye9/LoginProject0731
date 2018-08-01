package LoginTask.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

public class loginService {

	//1.JDBC
	/*@Autowired
	JoinerDao dao;*/
	
	//2. Spring jdbcTemplate
	/*@Autowired
	JdbcTemplateJoinerDao dao;*/
	
	//3. Spring MyBatis
	/*@Autowired
	MybatisJoinerDao dao;*/
	
	//4. Spring MyBatis Interface
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	JoinerInterfaceDao dao;
	
	// 로그인 확인 메서드
	public int login(String id, String pwd) throws ServiceException, SQLException{
		/*Connection conn = null;*/
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		int resultCnt = 0;

		/*try {*/
			/*conn = ConnectionProvider.getConnection();*/
			/*Joiner joiner = dao.selectOne(conn, id);*/
			/*Joiner joiner = dao.selectOne(id);*/
			Joiner joiner = dao.selectOne(id);
			
			if(joiner!= null) {
				if (joiner.getPwd()!= null) {
				//1.입력 비밀번호가 db의 비밀번호가 같다면
				if (joiner.getPwd().equals(pwd)) {		
					
					resultCnt = 1;
					
				//2.입력 비밀번호가 db의 비밀번호가 같지 않다면
				}else {
					resultCnt = 2;
				}
				
			//3.입력 비밀번호가 null이 이라면
			}else {
				resultCnt=3;
			}
				
		//0.아이디가 틀렸거나 입력되지 않았다면 
		}else {
			resultCnt=0;
		}

		/*} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("loginService.java에서 예외가 발생했습니다.");
		
		}finally {
			JdbcUtil.close(conn);
		}*/

		return resultCnt;
	}

}
