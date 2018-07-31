package LoginTask.service;

import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.dao.JdbcTemplateJoinerDao;
import LoginTask.model.Joiner;

public class DeleteMemberService {
	
	@Autowired
	JdbcTemplateJoinerDao dao;
	
	public boolean deleteMember(String id) {
		
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
