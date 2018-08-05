package org.launchcode.Healthcareinfomgt2.controllers;


import org.launchcode.Healthcareinfomgt2.models.data.UserDao;
import org.launchcode.Healthcareinfomgt2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;


@Controller
@RequestMapping("healthcare-info-mgt")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping (value="")
    public String index(Model model){
        System.out.println("test 1");
        return "index";
    }
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
        return "signup";


    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerUser(Model model, @ModelAttribute  @Valid User user,
                      Errors errors) {
        System.out.println("Sign up invoked..");
        if (errors.hasErrors()) {
            model.addAttribute("title", "User Signup");
            return "signup";
        }
        userDao.save(user);
        System.out.println("Sign up completed..");

        return "redirect:/login";
    }


}