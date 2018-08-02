package LoginTask.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LoginTask.model.Joiner;
import LoginTask.service.MemberListService;

@Controller
public class MemberJsonController {

	@Autowired
	MemberListService memberListService;
	
	@RequestMapping(value="/json/JoinerJson", method=RequestMethod.GET)
	public String getMemberJson(Joiner joiner, Model model) throws SQLException {
		
		List<Joiner> viewMem = memberListService.getMemberList2();
		model.addAttribute("viewMem", viewMem);
		return "JoinerJson";
	}
	
	@RequestMapping(value="/json/MemberAllPage", method=RequestMethod.GET)
	public String getMemberListJson(Joiner joiner, Model model) throws SQLException {
		return "JoinerJson";
	}
	
	
}
