package LoginTask.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import LoginTask.model.ConvertJoiner;
import LoginTask.model.ConvertJoinerList;
import LoginTask.model.Joiner;
import LoginTask.service.MemberListService;


@Controller
public class JoinerlistConvertController {
	
	@Autowired
	MemberListService memberListService;

	//엑셀
	@RequestMapping("/joinerList/xls")
	public ModelAndView getXlsPage() throws SQLException {
		List<Joiner> joinerList = memberListService.getMemberList2();

		return new ModelAndView("joinerListXmlView", "joinerList", joinerList);
	}
	
	//PDF
	@RequestMapping("/joinerList/pdf")
	public ModelAndView getPdfPage() throws SQLException {
		List<Joiner> joinerList = memberListService.getMemberList2();

		return new ModelAndView("joinerListPdfView", "joinerList", joinerList);
	}
	
	
	//Xml
	@RequestMapping(value="/joinerList/list.xml", method=RequestMethod.GET)
	public String getXmlPage() throws SQLException {
		return "MemberListConvertedForm";
	}
	
	@RequestMapping(value="/joinerList/list.xml", method=RequestMethod.POST)
	@ResponseBody
	public ConvertJoinerList actXmlPage(@RequestParam("from") String from, @RequestParam("to") String to) throws SQLException, ParseException {

		List<ConvertJoiner> joinerList = memberListService.actConvertedMemberList(from, to);

		return new ConvertJoinerList(joinerList);
	}
	
	
	//Json
	@RequestMapping("/joinerList/list.json")
	@ResponseBody
	public ConvertJoinerList getJsonPage() throws SQLException {
		List<ConvertJoiner> joinerList = memberListService.getConvertedMemberList();

		return new ConvertJoinerList(joinerList);
	}
	
}
