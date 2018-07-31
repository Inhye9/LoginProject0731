package LoginTask.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import LoginTask.model.Joiner;

public class JoinerRowMapper implements RowMapper<Joiner> {

	@Override
	public Joiner mapRow(ResultSet rs, int rowNum) throws SQLException {
		Joiner joiner = new Joiner();

		joiner.setId(rs.getString("ID"));
		joiner.setPwd(rs.getString("PWD"));
		joiner.setName(rs.getString("NAME"));

		Date Datebirth = rs.getDate("BIRTH");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String birth = transFormat.format(Datebirth);
		String[] birthArray = birth.split("-");

		joiner.setBirth_year(birthArray[0]);
		joiner.setBirth_mon(birthArray[1]);
		joiner.setBirth_day(birthArray[2]);

		joiner.setGender(rs.getString("GENDER"));
		joiner.setEmail(rs.getString("EMAIL"));
		joiner.setPhone(rs.getInt("PHONE"));
		joiner.setPhoto(rs.getString("PHOTO"));

		return joiner;

	}

}
