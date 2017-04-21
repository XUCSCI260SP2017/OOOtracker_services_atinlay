package edu.xavier.csci260.atinlay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/home", "/", "/logout"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String calendar() {
        return "calendar";
    }
}
