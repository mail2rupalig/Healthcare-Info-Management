package org.launchcode.Healthcareinfomgt2.controllers;


import org.launchcode.Healthcareinfomgt2.models.*;
import org.launchcode.Healthcareinfomgt2.models.data.DiseaseDao;
import org.launchcode.Healthcareinfomgt2.models.data.ProblemAreaDao;
import org.launchcode.Healthcareinfomgt2.models.data.UserDao;
import org.launchcode.Healthcareinfomgt2.models.data.UserTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("healthcare-info-mgt/personal/doctor")
public class DoctorController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DiseaseDao diseaseDao;

    @Autowired
    private ProblemAreaDao problemAreaDao;

    // Doctor landing page
    @RequestMapping(value="/landing", method=RequestMethod.GET)
    public String index(Model model){
        System.out.println("Doctor landing page..");
        model.addAttribute("title", "Doctor landing page");
        model.addAttribute("searchForm",new DoctorSearchForm());
        return "personal/doctor/landing";


    }

    // Doctor landing page
    @RequestMapping(value="/landing", method=RequestMethod.POST)
    public String search(@ModelAttribute @Valid DoctorSearchForm searchForm,
                        Errors errors, @RequestParam String searchCriteria, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Doctor landing page");
            return "personal/doctor/landing";
        }

        if(searchCriteria!=null){
            if(searchCriteria.equals("All")){
                searchForm.setSearchCriteria(searchCriteria);
                model.addAttribute("searchForm",searchForm);
                model.addAttribute("diseases", diseaseDao.findAll());
            }
        }

        model.addAttribute("title", "Doctor landing page");
        return "personal/doctor/landing";
    }

    // Doctor landing page
    @RequestMapping(value="/add-disease", method=RequestMethod.GET)
    public String addDiseaseTpPatient(Model model){
        System.out.println("Add disease landing page..");
        model.addAttribute("disease", new Disease());
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("problemareas",problemAreaDao.findAll());
        return "personal/doctor/add-disease";

    }

    // Doctor landing page
    @RequestMapping(value="/add-disease", method=RequestMethod.POST)
    public String search(@ModelAttribute @Valid Disease disease,
                         Errors errors, @RequestParam int userId, @RequestParam int problemAreaId,  Model model){
        System.out.println("Add disease submitted..");
        if (errors.hasErrors()) {
            return "personal/doctor/add-disease";
        }

        ProblemArea pArea = problemAreaDao.findOne(problemAreaId);
        disease.setProblemArea(pArea);

        User user = userDao.findOne(userId);
        disease.setPatient(user);

        diseaseDao.save(disease);

        model.addAttribute("diseases", diseaseDao.findAll());
        model.addAttribute("searchForm",new DoctorSearchForm());
        return "personal/doctor/landing";
    }

    @RequestMapping(value = "/disease/{diseaseId}", method = RequestMethod.GET)
    public String editDiseaseInfo(@PathVariable Integer diseaseId, Model model) {
        Disease disease = diseaseDao.findOne(diseaseId);

        model.addAttribute("title", "Edit Disease Information for ID: " + diseaseId);
        model.addAttribute("disease",disease);
        model.addAttribute("problemareas",problemAreaDao.findAll());
        return "personal/doctor/edit-disease-info";
    }



}