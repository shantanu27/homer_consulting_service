package com.homerconsulting.hc.dao;

import com.homerconsulting.hc.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ProjectDao extends CrudRepository<Project, Integer> {
    Project findByName(String name);
}
