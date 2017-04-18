package edu.xavier.csci260.atinlay.controller;

import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */

@Controller
public class MessageController
{
	@Autowired
	private AccessService accessService;

	/*
	 *this method will handle call in messages.html and give an array of all messages
	 */
	@RequestMapping(value = "/messages")
	public String messages(Model model)
	{
		Employee employee = accessService.getEmployee("ellisa4@xavier.edu");

		model.addAttribute("messages", accessService.getInbox(employee.getId(), false)); //find a way to get usernameService
		return "messages";
	}


}
