package com.homerconsulting.hc.dao;

import com.homerconsulting.hc.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface DepartmentDao extends CrudRepository<Department, Integer> {
}
