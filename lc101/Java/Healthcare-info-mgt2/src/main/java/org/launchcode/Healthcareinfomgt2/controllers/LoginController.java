package org.launchcode.Healthcareinfomgt2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("healthcare-info-mgt")
public class LoginController {

    @RequestMapping (value="")
    public String index(Model model){
        System.out.println("test 1");
        return "index";
    }
    // Login form
    @RequestMapping(value="/login.html", method=RequestMethod.GET)
    public String login() {
        return "login";
    }
}