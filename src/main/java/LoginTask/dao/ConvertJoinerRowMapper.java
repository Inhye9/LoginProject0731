package LoginTask.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import LoginTask.model.Joiner;
import LoginTask.model.ConvertJoiner;

public class ConvertJoinerRowMapper implements RowMapper<ConvertJoiner> {

	@Override
	public ConvertJoiner mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConvertJoiner joiner = new ConvertJoiner();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String birth = transFormat.format(rs.getDate("BIRTH").getTime());
		
		joiner.setId(rs.getString("ID"));
		joiner.setPwd(rs.getString("PWD"));
		joiner.setName(rs.getString("NAME"));
		joiner.setBirth(birth);
		joiner.setGender(rs.getString("GENDER"));
		joiner.setEmail(rs.getString("EMAIL"));
		joiner.setPhone(rs.getInt("PHONE"));
		joiner.setPhoto(rs.getString("PHOTO"));

		return joiner;

	}

}
