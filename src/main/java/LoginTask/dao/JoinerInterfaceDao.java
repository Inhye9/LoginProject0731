package LoginTask.dao;

import java.util.List;

import LoginTask.model.Joiner;

public interface JoinerInterfaceDao {

	public Joiner selectOne(String id);
	public int insert(Joiner joiner);
	public int selectCount();
	public List<Joiner> selectList(int firstRow, int endRow);
}
