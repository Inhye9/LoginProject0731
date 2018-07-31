package LoginTask.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.dao.JdbcTemplateJoinerDao;
import LoginTask.dao.JoinerDao;
import LoginTask.model.Joiner;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class selectMypageService {
	
	//싱글톤 
	/*private selectMypageService() {
	}
	
	private static selectMypageService instance = new selectMypageService();
	
	public static selectMypageService getInstance() {
		return instance;
	}*/
	
	/*@Autowired
	JoinerDao dao;*/
	
	@Autowired
	JdbcTemplateJoinerDao dao;
	
	//마이페이지 출력 메서드 
	public Joiner printMypage(String id) throws ServiceException, SQLException{
		
		/*Connection conn = null;*/
		int resultCnt = 0;
		Joiner joiner = null;
		
	/*	try {
			conn = ConnectionProvider.getConnection();*/
			/*oinerDao dao = JoinerDao.getInstance();*/
			
			/*joiner = dao.selectOne(conn, id);*/
			joiner = dao.selectOne(id);

		/*}catch (SQLException e) {
			e.printStackTrace();*/
		
		/*}finally {
			JdbcUtil.close(conn);
		}*/
		return joiner;
	}
}
