package LoginTask.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import LoginTask.model.Message;

public class MessageRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();

		message.setMessage_id(rs.getInt("message_id"));
		message.setId(rs.getString("id"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));

		return message;
	}

}
