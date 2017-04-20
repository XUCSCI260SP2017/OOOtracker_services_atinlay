package edu.xavier.csci260.atinlay.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;


/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */
@Controller
@RolesAllowed(value = "MANAGER")
public class ManagerController {

	@RequestMapping(value = "/manager/forTesting")
	@Secured("MANAGER")
	public String messages() {
		return "forTesting";
	}
}
