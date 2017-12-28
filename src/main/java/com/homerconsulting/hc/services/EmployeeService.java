package com.homerconsulting.hc.services;

import com.homerconsulting.hc.bo.EmployeeBO;
import com.homerconsulting.hc.dao.EmployeeDao;
import com.homerconsulting.hc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Collection<EmployeeBO> getAllEmployees() {
        List<EmployeeBO> employees = new ArrayList<>();
        employeeDao.findAll().forEach(employee -> employees.add(convertToBO(employee)));
        return employees;
    }

    public Optional<EmployeeBO> getEmployeeById(int id) {
        Employee employee = employeeDao.findOne(id);
        return Optional.ofNullable(employee).map(this::convertToBO);
    }

    public Collection<EmployeeBO> getEmployeesSupervisedBy(int id) throws NoSuchElementException{
        Employee employee = employeeDao.findOne(id);
        if (employee != null) {
            return employeeDao.findBySupervisor(employee)
                    .stream()
                    .map(this::convertToBO)
                    .collect(Collectors.toList());
        } else throw new NoSuchElementException("No such employee with id - " + id);
    }

    private EmployeeBO convertToBO(Employee employee) {
        return EmployeeBO.builder()
                .empID(employee.getEmpID())
                .empLast(employee.getEmpLast())
                .empFirst(employee.getEmpFirst())
                .dob(employee.getDob())
                .hireDate(employee.getHireDate())
                .supervisorId(Optional.ofNullable(employee.getSupervisor())
                        .map(Employee::getEmpID)
                        .orElse(null))
                .supervisorName(Optional.ofNullable(employee.getSupervisor())
                        .map(employee1 -> employee1.getEmpFirst() + " " + employee1.getEmpLast())
                        .orElse(""))
                .departmentId(employee.getDepartment().getDeptCode())
                .departmentName(employee.getDepartment().getName())
                .build();
    }
}
