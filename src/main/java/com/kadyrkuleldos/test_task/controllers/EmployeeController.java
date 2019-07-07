package com.kadyrkuleldos.test_task.controllers;

import com.kadyrkuleldos.test_task.exception.EmployeesNotFoundException;
import com.kadyrkuleldos.test_task.models.Employees;
import com.kadyrkuleldos.test_task.repository.EmployeesRepo;
import com.kadyrkuleldos.test_task.service.EmployeesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeesService service;
    private final EmployeesRepo employeesRepo;

    @Autowired
    public EmployeeController(EmployeesService employeesService, EmployeesRepo employeesRepo) {
        this.service = employeesService;
        this.employeesRepo = employeesRepo;
    }

    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public List<Employees> getEmployees() {
        return service.getEmployeesList();
    }

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody Employees employees) {
        service.saveEmployees(employees);
    }


    @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employees> getEmployeeByUID(@PathVariable(value = "id") int employeeID) {
        Employees employees = null;
        if (employeesRepo.existsById((long) employees.getID())) {
            Employees employeesFromID = null;
            try {
                employeesFromID = employeesRepo.findById(employees.getID())
                        .orElseThrow(()-> {
                            return new EmployeesNotFoundException(String.format("Данный ID сотрудника не существует " + employees.getID()));
                        });
            } catch (EmployeesNotFoundException e) {
                e.printStackTrace();
            }
            employees.setFirstname(employeesFromID.getFirstname());
            employees.setLastname(employeesFromID.getLastname());
            employees.setSurname(employeesFromID.getSurname());
            employees.setEmail(employeesFromID.getSurname());
            employees.setGender(employeesFromID.getGender());
        }

        employeesRepo.findById(employeeID);

        return ResponseEntity.ok().body(employees);
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int employeeID) {
        Employees employees = null;
        if (employeesRepo.existsById((long) employees.getID())) {
            Employees employees1 = null;
            try {
                employees1 = employeesRepo.findById(employees.getID())
                        .orElseThrow(() -> {
                            return new EmployeesNotFoundException("Данный ID сотрудника не существует " + employees.getID());
                        });
            } catch (EmployeesNotFoundException e) {
                e.printStackTrace();
            }
        }

        employeesRepo.delete(employees);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }
}
