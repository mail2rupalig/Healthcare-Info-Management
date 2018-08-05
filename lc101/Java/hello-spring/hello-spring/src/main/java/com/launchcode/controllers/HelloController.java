package com.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {


    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " +name;

    }
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloform() {

        String html = "<form method='post'>" +
                "<input type='text' name='name'/>" +

                "<select name='lang'>"+
                "<option value='Hola'>Spanish</option>" +
                "<option value='Bonjour' selected>French</option>" +
                "<option value='Jambo'>Swahili</option>" +
                "<option value='Ni Hau'>Mandarin</option>" +
                "<option value='SAIN BAINUU'>Mongolian</option>" +
                "</select>" +
                "<input type= 'submit' value='Greet Me!'/>"+
                "</form>";

        return html;
    }


    public String helloLan(String lang, String name) {

        String value = "";
        switch (lang) {

            case "Hola":
                value = "Hola ";
                break;
            case "Bonjour":
                value = "Bonjour ";
                break;
            case "Jambo":
                value = "Jambo ";
                break;
            case "Ni Hau":
                value = "Ni Hau ";
                break;
            case "SAIN BAINUU":
                value = "SAIN BAINUU ";
                break;

        }
        return value + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("name");
        String lang = request.getParameter("lang");
        return helloLan(lang, name);

    }
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String  helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }


    @RequestMapping(value = "goodbye")
    public String goodbye() {

        return "redirect:/";
    }
}
