package com.homerconsulting.hc.dao;

import com.homerconsulting.hc.model.Assignment;
import com.homerconsulting.hc.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(exported = false)
public interface AssignmentDao extends CrudRepository<Assignment, Integer> {
    Collection<Assignment> findByEmployee(Employee employee);
}
