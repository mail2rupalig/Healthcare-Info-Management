package org.launchcode.Healthcareinfomgt2.controllers;


import org.launchcode.Healthcareinfomgt2.models.data.UserDao;
import org.launchcode.Healthcareinfomgt2.models.data.UserTypeDao;
import org.launchcode.Healthcareinfomgt2.models.User;
import org.launchcode.Healthcareinfomgt2.models.UserType;
import org.launchcode.Healthcareinfomgt2.models.UserLogin;
import org.launchcode.Healthcareinfomgt2.service.EncodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.lang.Iterable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@Controller
@RequestMapping("healthcare-info-mgt")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @Autowired
    private EncodingService encodingService;

    // Index form
    @RequestMapping (value="")
    public String index(Model model){
        System.out.println("test 1");
        return "index";
    }

    // Login form
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "User Login");
        model.addAttribute("user", new UserLogin());
        return "login";
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String registerUser(@ModelAttribute @Valid UserLogin user,
//                               Errors errors, Model model) {
//        System.out.println("Login invoked..");
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "User Login");
//            return "login";
//        }
//
//        Iterable<User> users = userDao.findAll();
//
//        if(users!=null){
//            for(User usr:users){
////                System.out.println("Credentials - "+user.getUserName() + ":" + user.getPassword());
////                System.out.println("DB - "+usr.getUserName() + ":" + usr.getPassword());
////
//            if(usr.getUserName().equals(user.getUserName()) && usr.getPassword().equals(user.getPassword())){
//                System.out.println("usr name and pwd match..");
//                    if(usr.getUserType().getType().equals("Doctor")){
//                        return "redirect:/healthcare-info-mgt/doctor/landing";
//                    }else if(usr.getUserType().getType().equals("Patient")){
//                        return "redirect:/healthcare-info-mgt/patient/landing";
//                    }
//                }
//            }
//        }

//        userDao.save(user);
//        System.out.println("Login completed..");

//        model.addAttribute("loginError", "True");
//        model.addAttribute("user", user);
//        return "login";
//    }

    // Sign Up form
    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signup(Model model){
        System.out.println("Sign up invoked first time..");
        model.addAttribute("title", "User Sign Up");
        model.addAttribute(new User());
        model.addAttribute("userTypes", userTypeDao.findAll());
        return "signup";


    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute @Valid User user,
                      Errors errors, @RequestParam int userTypeId, Model model) {
        System.out.println("Sign up invoked..");

        if (errors.hasErrors()) {
            model.addAttribute("title", "User Signup");
            model.addAttribute("userTypes", userTypeDao.findAll());
            return "signup";
        }

        UserType usrType = userTypeDao.findOne(userTypeId);
        user.setUserType(usrType);
        user.setEnabled(true);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());

//        System.out.println("hashedPassword.."+hashedPassword);

//        String encryptedPassword = encodingService.encode(user.getPassword());

//        user.setPassword(user.getPassword());

        user.setPassword(hashedPassword);
        userDao.save(user);
        System.out.println("Sign up completed..");

        return "redirect:/healthcare-info-mgt/login";
    }


}