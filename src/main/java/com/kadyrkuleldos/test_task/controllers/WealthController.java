package com.kadyrkuleldos.test_task.controllers;

import com.kadyrkuleldos.test_task.models.Wealth;
import com.kadyrkuleldos.test_task.service.WealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/wealth"})
public class WealthController {

    private final WealthService service;

    @Autowired
    public WealthController(WealthService wealthService) {
        this.service = wealthService;
    }

    @RequestMapping("/all")
    public List<Wealth> getWealth() {
        return service.getWealthList();
    }

    @RequestMapping("/add")
    public void insertWealth(@RequestBody Wealth wealth) {
        service.saveWealth(wealth);
    }


}
