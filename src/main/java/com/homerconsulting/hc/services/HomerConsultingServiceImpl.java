package com.homerconsulting.hc.services;

import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.dao.ClientDao;
import com.homerconsulting.hc.dao.DepartmentDao;
import com.homerconsulting.hc.model.Client;
import com.homerconsulting.hc.model.Department;
import com.homerconsulting.hc.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Optional;

@Service
public class HomerConsultingServiceImpl implements HomerConsultingService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private ClientDao clientDao;

    @Override
    public ProjectBO createProject(ProjectBO projectBO) throws IllegalArgumentException, ParseException{
        Department department = Optional.of(departmentDao.findOne(projectBO.getDeptCode()))
                .orElseThrow(() -> new IllegalArgumentException("Create Project: " +
                        "Invalid department code - " + projectBO.getDeptCode()));
        Client client = Optional.of(clientDao.findOne(projectBO.getClientID()))
                .orElseThrow(() -> new IllegalArgumentException("Create Project: " +
                        "Invalid project id - " + projectBO.getClientID()));
        Timestamp startDate = Optional.ofNullable(projectBO.getStartDate()).orElse(new Timestamp(System.currentTimeMillis()));
        return projectService.saveProject(new Project(projectBO.getProjID(),
                                                      projectBO.getName(),
                                                      startDate,
                                                      projectBO.getTotalCost(),
                                                      department,
                                                      client));
    }
}
