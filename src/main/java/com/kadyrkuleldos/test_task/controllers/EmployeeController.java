package com.kadyrkuleldos.test_task.controllers;

import com.kadyrkuleldos.test_task.models.Employees;
import com.kadyrkuleldos.test_task.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeesService service;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(ModelMap modelMap, HttpServletRequest request) {
        String first_name = request.getParameter("firstname");
        String last_name = request.getParameter("lastname");
        String sur_name = request.getParameter("surname");
        String email_employee = request.getParameter("email");
        String gender_employee = request.getParameter("gender");

        service.insertEmployess(first_name, last_name, sur_name, email_employee, gender_employee);
        String referer = request.getHeader("referer")
                .replaceAll("http://", "")
                .replace(request.getServerName() + ":", "")
                .replace(String.valueOf(request.getServerPort()), "");

        return request.getPathInfo();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String  updateEmployee(ModelMap modelMap, HttpServletRequest request) {
        Employees employees = null;
        service.updateEmployess();

        modelMap.addAttribute("firstname", employees.getFirstname());
        modelMap.addAttribute("lastname", employees.getLastname());
        modelMap.addAttribute("surname", employees.getSurname());
        modelMap.addAttribute("email", employees.getEmail());
        modelMap.addAttribute("gender", employees.getGender());

        String referer = request.getHeader("referer")
                .replaceAll("http://", "")
                .replace(request.getServerName() + ":", "")
                .replace(String.valueOf(request.getServerPort()), "");

        return request.getPathInfo();
    }

}
