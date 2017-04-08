package edu.xavier.csci260.Phase_1.controller;

import edu.xavier.csci260.Phase_1.domain.Message;
import edu.xavier.csci260.Phase_1.dal.MessageDAO;
import edu.xavier.csci260.Phase_1.dal.MessageDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */

@Controller
public class MessageController
{
	private MessageDAO messageDAO;

	public MessageController(MessageDAO message)
	{
		messageDAO=message;
	}

	/*
	 *this method will handle call in messages.html and give an array of all messages
	 */
	@RequestMapping(value = "/messages")
	public String messages(Model model)
	{
		model.addAttribute("messages", messageDAO.getMessagesBySender("user")); //find a way to get usernameService 
		return "messages";
	}
}
