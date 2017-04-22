package edu.xavier.csci260.atinlay.controller;

import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.service.EmployeeService;
import edu.xavier.csci260.atinlay.dal.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */
@Controller
public class MessageController {

	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private EmployeeService employeeService;
	/*
	 *this method will handle call in messages.html and give an array of all messages
	 */
	@RequestMapping(value = "/messages/{username}")
	public String messages(Model model, @PathVariable("username")String username)
	{
		Employee employee = employeeService.getEmployee(username);

		model.addAttribute("messages", employeeService.getInbox(	employee));
		return "messages";
	}
	
	@RequestMapping(value = "/readMessage/{messageID}")
	public String readMessage(Model model, @PathVariable("messageID")Long messageID)
	{
		model.addAttribute("readMessage", messageDAO.getMessageById(messageID));
		return "readMessage";
	}
	
	@RequestMapping(value = "/compose", method=RequestMethod.POST)
	public String compose()
	{
		return "compose";
	}
}
