package org.launchcode.cheesemvc.controllers;


@Controller
@RequestMapping("recipes")
public class RecipesController {

    //* Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("title", "My Recipes");

        return "recipes/index";
    }
}

