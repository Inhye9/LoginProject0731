package LoginTask.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LoginTask.model.MemberListView;
import LoginTask.service.DeleteMemberService;
import LoginTask.service.MemberListService;
import LoginTask.service.ServiceException;

@Controller
public class MemberListController {

	@Autowired
	MemberListService memberListService;
	
	@Autowired
	DeleteMemberService deleteMemberService;
	
	@RequestMapping(value="/MemberAllPage", method=RequestMethod.GET)
	public String getMemberList(MemberListView memberListView, Model model) throws ServiceException, SQLException {
		
		int pageNumber = 1;
			
		model.addAttribute("memberListView", memberListService.getMemberList(pageNumber));
		
		return "MemberAllPage";
	}
	
	
	@RequestMapping(value="/MemberAllPage/{page}", method=RequestMethod.GET)
	public String getMemberListPage(@PathVariable("page") String pageNumberStr , MemberListView memberListView, Model model) throws ServiceException, SQLException {
		
		int pageNumber = 1;
		
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
			
		model.addAttribute("memberListView", memberListService.getMemberList(pageNumber));
		
		return "MemberAllPage";
	}
	
	
	@RequestMapping(value="/MemberDelete/{id}", method=RequestMethod.GET)
	public String getDeleteMember(@PathVariable("id") String Deleteid, HttpServletRequest request, Model model) {
		
		String id = (String)request.getSession(true).getAttribute("id");
		
		if(id.equals("admin0")) {
			model.addAttribute("result", deleteMemberService.deleteMember(Deleteid));
		}else {
			model.addAttribute("result", false);
		}
		
		return "MemberDeleteAct";
	}
}
