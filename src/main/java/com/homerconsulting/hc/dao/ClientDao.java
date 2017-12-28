package com.homerconsulting.hc.dao;

import com.homerconsulting.hc.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ClientDao extends CrudRepository<Client, Integer> {
}
