package com.kadyrkuleldos.test_task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap modelMap) {
        modelMap.addAttribute("application", "Test Service");
        return "welcome";
    }

    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
    public String listEmployee(ModelMap modelMap) {
        return "list_employees";
    }
}
