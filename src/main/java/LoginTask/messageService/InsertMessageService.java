package LoginTask.messageService;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.dao.JdbcTemplateMessageDao;
import LoginTask.dao.JoinerInterfaceDao;
import LoginTask.dao.MessageDao;
import LoginTask.model.Message;
import LoginTask.service.ServiceException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class InsertMessageService {

	/*@Autowired
	MessageDao dao;*/
	
/*	@Autowired
	JdbcTemplateMessageDao dao;*/
	
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	JoinerInterfaceDao dao;
	
	//방명록 삽입 메서드 
	public int write(Message message) throws ServiceException{
		
		dao = sqlsessionTemplate.getMapper(JoinerInterfaceDao.class);
		/*Connection conn = null;*/
		int resultCnt = 0;
		
		System.out.println("입력 전 message_id : " + message.getMessage_id());
		
		resultCnt = dao.insertMessage(message);
		
		System.out.println("입력 후 message_id : " + message.getMessage_id());
		/*try {
			conn = ConnectionProvider.getConnection();

			resultCnt = dao.insert(conn, message);
			
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		
		}finally {
			JdbcUtil.close(conn);
		}*/
		
		return resultCnt;
		
	}
	

}
