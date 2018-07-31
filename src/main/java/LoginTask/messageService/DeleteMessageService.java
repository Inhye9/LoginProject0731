package LoginTask.messageService;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.dao.JdbcTemplateMessageDao;
import LoginTask.dao.MessageDao;
import LoginTask.model.Message;
import LoginTask.service.ServiceException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteMessageService {
	
	/*@Autowired
	MessageDao dao;*/
	
	@Autowired
	JdbcTemplateMessageDao dao;
	
	//메세지 삭제 메서드
	public boolean deleteMessage(String id, int messageId) throws ServiceException, SQLException{
		
		/*Connection conn = null;*/
		boolean result = false;
		/*try {*/
			
			/*conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);*/
			
			Message message = dao.select(messageId);
		/*	Message message = dao.select(conn, messageId);*/
			
			if (message == null) {
				result = false;
			}
			
			if (!message.hasId()) {
				result = false;
			}
			
			if(message.getId().equals(id)) {
				if(dao.delete(messageId)){
					result = true;
				}else {
					result = false;
				}
			}

			
	/*	} catch (SQLException e) {
			JdbcUtil.rollback(conn);

		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(false);
				} catch (SQLException e) {
				}
				JdbcUtil.close(conn);
			}
		}*/
		return result;
	}
}
