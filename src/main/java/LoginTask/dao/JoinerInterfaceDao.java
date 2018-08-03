package LoginTask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import LoginTask.model.Joiner;

public interface JoinerInterfaceDao {

	public Joiner selectOne(String id);
	public int insert(Joiner joiner);
	public int selectCount();
	public List<Joiner> selectList(int firstRow, int endRow);
	
	public int updateConfirmbyMail(String id);
	public int updateTempPwd(@Param("id") String id, @Param("pwd") String pwd); //@Param으로 읽어올 것.
}
