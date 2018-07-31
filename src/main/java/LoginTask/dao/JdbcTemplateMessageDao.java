package LoginTask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.MethodWrapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import LoginTask.model.Message;

public class JdbcTemplateMessageDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//insert
	public int insert(Message message) {
		
		int resultCnt = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "insert into guestbook_message values (message_id_seq.NEXTVAL, ?, ?, ?)";
		
		resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				
				pstmt = con.prepareStatement(sql, new String[] {"MESSAGE_ID"});
				pstmt.setString(1, message.getId());
				pstmt.setString(2, message.getPassword());
				pstmt.setString(3, message.getMessage());
				
				return pstmt;
			}
			
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		message.setMessage_id(keyValue.intValue());
		
		/*resultCnt = jdbcTemplate.update(sql, message.getId(), message.getPassword(), message.getMessage());*/
		
		return resultCnt;
	}
	
	//List
	public int selectCount() {
	
		int resultCnt = 0;
		String sql = "select count(*) from guestbook_message";
		
		resultCnt = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return resultCnt;
	}
	
	public List<Message> selectList(int firstRow, int endRow){
		
		List<Message> messageList = null;

		String sql = "select message_id, id, password, message  " + 
				"from ( select rownum rnum, message_id, id, password, message  " + 
				"        from ( select *  " + 
				"               from guestbook_message m  " + 
				"               order by m.message_id desc)  " + 
				"        where rownum <= ?)  " + 
				"where rnum >= ?";
		
		messageList = jdbcTemplate.query(sql, new MessageRowMapper(), endRow, firstRow);
		
		return messageList;
	}
	
	//Delete
	public Message select(int messageId) {
		
		Message message = null;
		String sql = "select * from guestbook_message where message_id=?";
		
		message = jdbcTemplate.queryForObject(sql, new MessageRowMapper(), messageId);
		
		return message;
		
	}
	
	public boolean delete(int messageId) {
		
		boolean result = false;
		String sql = "delete from guestbook_message where message_id = ?";
		
		if(jdbcTemplate.update(sql,messageId) == 1) {
			result = true;
		}
		
		return result;
		
	}

}
