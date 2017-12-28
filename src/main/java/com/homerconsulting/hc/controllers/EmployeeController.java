package com.homerconsulting.hc.controllers;

import com.homerconsulting.hc.bo.EmployeeBO;
import com.homerconsulting.hc.model.Employee;
import com.homerconsulting.hc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/hc/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<EmployeeBO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public EmployeeBO getEmployeeById(@PathVariable(value = "id") int id) throws NoSuchElementException {
        return employeeService.getEmployeeById(id)
                .orElseThrow(() -> new NoSuchElementException("No employee with id " + id));
    }

    @RequestMapping(path = "supervisor/{id}")
    public Collection<EmployeeBO> getSupervisedEmployees(@PathVariable(value = "id") int id) throws NoSuchElementException {
        return employeeService.getEmployeesSupervisedBy(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String catchError(NoSuchElementException e) {
        return e.getMessage();
    }
}
