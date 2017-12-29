package com.homerconsulting.hc.dao;

import com.homerconsulting.hc.model.Department;
import com.homerconsulting.hc.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(exported = false)
public interface DepartmentDao extends CrudRepository<Department, Integer> {
}
