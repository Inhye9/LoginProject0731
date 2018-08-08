package LoginTask.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import LoginTask.model.ConvertJoiner;
import LoginTask.model.Joiner;
import LoginTask.model.Message;

public interface JoinerInterfaceDao {

	public Joiner selectOne(String id);
	public int insert(Joiner joiner);

	public int updateConfirmbyMail(String id);
	public int updateTempPwd(@Param("id") String id, @Param("pwd") String pwd); //@Param으로 읽어올 것.

	public List<Joiner> selectList(@Param("firstRow") int firstRow, @Param("endRow") int endRow);
	public int selectCount();
	
	public List<Joiner> selectAll();
	public List<Joiner> convertedListbyBirth1(@Param("from") String from, @Param("to") String to);
	
	public List<ConvertJoiner> convertedSelectAll();
	public List<ConvertJoiner> convertedListbyBirth(@Param("from") String from, @Param("to") String to);
	
	public boolean delete(@Param("id") String id);
	
	//방명록
	public int insertMessage(Message message);
	public int selectMessageCount();
	public List<Message> selectMessageList(@Param("firstRow") int firstRow, @Param("endRow") int endRow);
	public Message selectMessage(@Param("messageId") int messageId);
	public boolean deleteMessage(@Param("messageId") int messageId);
}
