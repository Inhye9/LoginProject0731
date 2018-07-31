package LoginTask.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class logoutController {

	@RequestMapping(value="/logoutAct", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		request.getSession(false).invalidate();
		return "redirect:/";
		/*return "logoutAct";*/
	}
}
