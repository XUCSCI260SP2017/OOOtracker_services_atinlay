package edu.xavier.csci260.atinlay.controller;

import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */

@Controller
public class MessageController
{
	@Autowired
	private EmployeeService employeeService;

	/*
	 *this method will handle call in messages.html and give an array of all messages
	 */
	@RequestMapping(value = "/messages")
	public String messages(Model model)
	{
		Employee employee = employeeService.getEmployee("ellisa4@xavier.edu");

		model.addAttribute("messages", employeeService.getInbox(employee)); //find a way to get usernameService
		return "messages";
	}


}
