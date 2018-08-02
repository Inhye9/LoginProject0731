package LoginTask.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import LoginTask.model.Joiner;
import LoginTask.service.ServiceException;
import LoginTask.service.selectMypageService;

@Controller
public class MypageController {
	
	@Autowired
	selectMypageService selectMypageService;
	
	@RequestMapping(value="/MyPageForm", produces="text/plain; charset=UTF-8")
	public String getMypage(HttpServletRequest request, HttpServletResponse response, Joiner joiner) throws ServiceException, IOException, SQLException {
		
		String id = (String)request.getSession(true).getAttribute("id");
		
		if(id!=null) {

		joiner.setId(selectMypageService.printMypage(id).getId());
		joiner.setPwd(selectMypageService.printMypage(id).getPwd());
		joiner.setName(selectMypageService.printMypage(id).getName());
	/*	joiner.setBirth_year(selectMypageService.printMypage(id).getBirth_year());
		joiner.setBirth_mon(selectMypageService.printMypage(id).getBirth_mon());
		joiner.setBirth_day(selectMypageService.printMypage(id).getBirth_day());*/
		joiner.setBirth(selectMypageService.printMypage(id).getBirth());
		joiner.setGender(selectMypageService.printMypage(id).getGender());
		joiner.setEmail(selectMypageService.printMypage(id).getEmail());
		joiner.setPhone(selectMypageService.printMypage(id).getPhone());
		joiner.setPhoto(selectMypageService.printMypage(id).getPhoto());
		
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 해주세요')");
			out.println("location.href='loginForm'");
			out.println("</script>");
		}
		
		return "MyPageForm";
	}

}
