package com.homerconsulting.hc.services;

import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.dao.ProjectDao;
import com.homerconsulting.hc.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public Collection<ProjectBO> getAllProjects() {
        List<ProjectBO> projects = new ArrayList<>();
        projectDao.findAll()
                .forEach(project -> projects.add(convertToBO(project)));
        return projects;
    }

    public Optional<ProjectBO> getProjectById(int id) {
        Project project = projectDao.findOne(id);
        return Optional.ofNullable(project).map(this::convertToBO);
    }

    public Collection<ProjectBO> getActiveProjects() {
        List<Project> projects = new ArrayList<>();
        projectDao.findAll().forEach(projects::add);
        return projects.stream()
                .filter(project -> project.getTotalCost() == null)
                .map(this::convertToBO)
                .collect(Collectors.toList());
    }

    public ProjectBO saveProject(Project project) throws IllegalArgumentException {
        boolean exists = validateProject(project.getName());
        if (!exists) {
            Project createdProject = projectDao.save(project);
            return convertToBO(createdProject);
        } else throw new IllegalArgumentException("Project with name '" + project.getName() + "' already exists!");
    }

    private boolean validateProject(Integer id) {
        Project project = projectDao.findOne(id);
        return project != null;
    }

    private boolean validateProject(String name) {
        Project project = projectDao.findByName(name);
        return project != null;
    }

    private ProjectBO convertToBO(Project project) {
        return ProjectBO.builder()
                .projID(project.getProjID())
                .name(project.getName())
                .startDate(project.getStartDate())
                .totalCost(project.getTotalCost())
                .deptCode(project.getDepartment().getDeptCode())
                .deptName(project.getDepartment().getName())
                .clientID(project.getClient().getClientID())
                .clientName(project.getClient().getName())
                .build();
    }
}
