package LoginTask.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.dao.JdbcTemplateJoinerDao;
import LoginTask.dao.JoinerInterfaceDao;
import LoginTask.model.Joiner;

public class DeleteMemberService {
	
	/*@Autowired
	JdbcTemplateJoinerDao dao;*/
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	JoinerInterfaceDao dao;
	
	public boolean deleteMember(String id) {
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		boolean result = true;
		
		Joiner joiner = dao.selectOne(id);
		if(dao.delete(id)) {
			result = true;
		};
		
		if(joiner == null) {
			result = false;
		}
	
		return result;
		
	}

}
