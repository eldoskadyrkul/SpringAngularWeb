package com.kadyrkuleldos.test_task.controllers;

import com.kadyrkuleldos.test_task.models.Employees;
import com.kadyrkuleldos.test_task.service.EmployeesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeesService service;

    @Autowired
    public EmployeeController(EmployeesService employeesService) {
        this.service = employeesService;
    }

    @RequestMapping("/api/employees")
    public List<Employees> getEmployees() {
        return service.getEmployeesList();
    }

    @RequestMapping("/api/employee")
    public void insertEmployee(@RequestBody Employees employees) {
        service.saveEmployees(employees);
    }

    /*
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
    */
}
