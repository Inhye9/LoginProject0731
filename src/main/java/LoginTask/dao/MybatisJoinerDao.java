package LoginTask.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.model.Joiner;

public class MybatisJoinerDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//Mypage
	public Joiner selectOne(String id) {
		String sql = "LoginTask.mapper.mybatis.JoinerMapper.selectById";
		System.out.println("MybatisDao SelectOne 메서드 실행-----------");
		return (Joiner)sqlSessionTemplate.selectOne(sql, id);
	}
	
	//Register
	public int insert(Joiner joiner) {
		System.out.println("MybatisDao insertJoiner 메서드 실행-----------");
		return sqlSessionTemplate.update("LoginTask.mapper.mybatis.JoinerMapper.insertJoiner", joiner);
	}
}
