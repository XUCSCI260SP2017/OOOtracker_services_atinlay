package edu.xavier.csci260.atinlay.controller;

import edu.xavier.csci260.atinlay.service.AccessService;
import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller handles RequestCalls in html
 * Created by Andre Ellis on 04/06/2017
 */
@Controller
public class RequestController {

	@Autowired
	private AccessService accessService;

	@RequestMapping(value = "/newRequest", method = RequestMethod.GET)
	public String getNewRequest(Model model)
	{
		model.addAttribute("TimeOffReq", new TimeOffReq());
		return "newRequest";
	}

	@RequestMapping(value = "/newRequest", method = RequestMethod.POST)
	public String newRequest(@ModelAttribute TimeOffReq timeOffReq, Model model) {
		String manager=accessService.getEmployee( timeOffReq.getEmployee() ).getManager_id();
		String employee=timeOffReq.getEmployee();
		String description = timeOffReq.getDescription();
		String reason = timeOffReq.getDescription();

		accessService.requestEvent(manager, employee, description, reason, timeOffReq.getStartTimestamp(), timeOffReq.getEndTimestamp());
		return "newRequest";
    	}
}
