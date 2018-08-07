package org.launchcode.Healthcareinfomgt2.controllers;


import org.launchcode.Healthcareinfomgt2.models.data.UserDao;
import org.launchcode.Healthcareinfomgt2.models.data.UserTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("healthcare-info-mgt/patient")
public class PatientController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;


    // Sign Up form
    @RequestMapping(value="/landing", method=RequestMethod.GET)
    public String signup(Model model){
        model.addAttribute("title", "Patient landing page");
        return "patient/landing";


    }



}