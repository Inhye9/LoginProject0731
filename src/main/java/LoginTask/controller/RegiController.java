package LoginTask.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LoginTask.model.Joiner;
import LoginTask.service.ServiceException;
import LoginTask.service.insertJoinerService;

@Controller
public class RegiController {
	
	@Autowired
	insertJoinerService insertJoinerService;
	
	@RequestMapping(value="/regi/RegisterFirst", method=RequestMethod.GET)
	public String getRegisterFirst() {
		return "RegisterFirst";
	}
	
	@RequestMapping(value="/regi/RegisterSecond", method=RequestMethod.GET)
	public String getRegisterSecond() {
		return "RegisterSecond";
	}
	
	@RequestMapping(value="/regi/RegisterAct", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String postRegisterSecond(HttpServletRequest request, Joiner joiner, Model model) throws ServiceException, IllegalStateException, IOException, SQLException {
		
		int resultCnt = 0;
		
		resultCnt = insertJoinerService.insertJoiner(joiner, request);
		model.addAttribute("resultCntTmp", resultCnt);
		
		/*ModelAndView*/
		return "RegisterAct";
	}

}
