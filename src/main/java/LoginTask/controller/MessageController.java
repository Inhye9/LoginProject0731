package LoginTask.controller;

import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LoginTask.messageService.DeleteMessageService;
import LoginTask.messageService.InsertMessageService;
import LoginTask.messageService.MessageListService;
import LoginTask.model.Message;
import LoginTask.model.MessageListView;
import LoginTask.service.ServiceException;
import LoginTask.service.insertJoinerService;

@Controller
public class MessageController {
	
	@Autowired
	MessageListService messageListService;

	@Autowired
	InsertMessageService InsertMessageService;
	
	@Autowired
	DeleteMessageService deleteMessageService;
	
	
	//방명록 리스트
	@RequestMapping(value="/message/MessageListForm", method=RequestMethod.GET)
	public String getMessageList(MessageListView messageListView, Model model) throws ServiceException {
		
		int pageNumber = 1;
		model.addAttribute ("messageListView", messageListService.getMessageList(pageNumber));
		
		return "MessageListForm";
	}
	
	@RequestMapping(value="/message/MessageListForm/{page}", method=RequestMethod.GET)
	public String getMessageListPage(@PathVariable("page") String pageNumberStr, MessageListView messageListView, Model model) throws ServiceException {
		
		int pageNumber = 1;
		
		if(pageNumberStr != null) {
			pageNumber= Integer.parseInt(pageNumberStr);
		}
		
		model.addAttribute ("messageListView", messageListService.getMessageList(pageNumber));
		
		return "MessageListForm";
	}
	
	
	
	//방명록 글쓰기
	@RequestMapping(value="/message/MessageInsertForm", method=RequestMethod.GET)
	public String insertMessage() {
		return "MessageInsertForm";
	}

	
	@RequestMapping(value="/message/MessageInsertAct", method=RequestMethod.POST)
	public String insertMessageAct(Message message, Model model) throws ServiceException {
		int resultCnt = 0;
		
		model.addAttribute("resultCntTmp", InsertMessageService.write(message));
		
		return "MessageInsertAct";
	}
	
	
	//방명록 글삭제
	@RequestMapping(value="/message/MessageDeleteAct/{messageId}", method=RequestMethod.GET)
	public String deleteMessage(@PathVariable("messageId") int messageId, HttpServletRequest request, Model model) throws ServiceException, SQLException {
		
		boolean vaildPwd;
		String id = (String)request.getSession(true).getAttribute("id");
		String pwd = (String)request.getSession(true).getAttribute("pwd");
		
		if(id!=null && pwd!=null) {
			model.addAttribute("vaildPwd", deleteMessageService.deleteMessage(id, messageId) );
		}
		return "MessageDeleteAct";
	}


	
	
	
}
