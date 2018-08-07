package org.launchcode.Healthcareinfomgt2.controllers;


import org.launchcode.Healthcareinfomgt2.models.User;
import org.launchcode.Healthcareinfomgt2.models.UserType;
import org.launchcode.Healthcareinfomgt2.models.data.UserDao;
import org.launchcode.Healthcareinfomgt2.models.data.UserTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("healthcare-info-mgt/doctor")
public class DoctorController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;


    // Sign Up form
    @RequestMapping(value="/landing", method=RequestMethod.GET)
    public String signup(Model model){
        model.addAttribute("title", "Doctor landing page");
        return "doctor/landing";


    }



}