package com.homerconsulting.hc.dao;

import com.homerconsulting.hc.model.Department;
import com.homerconsulting.hc.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@RepositoryRestResource(exported = false)
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    Collection<Employee> findBySupervisor(Employee supervisor);
    Collection<Employee> findByDepartment(Department department);
}
