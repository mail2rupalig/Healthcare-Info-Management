package org.launchcode.Healthcareinfomgt2.controllers;


import org.launchcode.Healthcareinfomgt2.models.data.UserDao;
import org.launchcode.Healthcareinfomgt2.models.data.UserTypeDao;
import org.launchcode.Healthcareinfomgt2.models.User;
import org.launchcode.Healthcareinfomgt2.models.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
@RequestMapping("healthcare-info-mgt")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;

    // Login form
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    // Sign Up form
    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signup(Model model){
        model.addAttribute("title", "User Sign Up");
        model.addAttribute(new User());
        model.addAttribute("userTypes", userTypeDao.findAll());
        return "signup";


    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute @Valid User user,
                      Errors errors, @RequestParam int userTypeId, Model model) {
        System.out.println("Sign up invoked..");
        if(user!=null){
            System.out.println("User first name " + user.getFirstName());
            System.out.println("User last name " + user.getLastName());
            System.out.println("User insurance id " + user.getInsuranceId());
        }else{
            System.out.println("User found null..");
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "User Signup");
            return "signup";
        }

        UserType usrType = userTypeDao.findOne(userTypeId);
        user.setUserType(usrType);
        userDao.save(user);
        System.out.println("Sign up completed..");

        return "redirect:/healthcare-info-mgt/login";
    }


}