package com.homerconsulting.hc.controllers;

import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/hc/projects/")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<ProjectBO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ProjectBO getById(@PathVariable(value = "id") int id) throws NoSuchElementException {
        return projectService.getProjectById(id)
                .orElseThrow(() -> new NoSuchElementException("No project with id " + id));
    }

    @RequestMapping(path = "ongoing", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<ProjectBO> getOngoingProjects() {
        return projectService.getActiveProjects();
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String catchError(NoSuchElementException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String catchError(IllegalArgumentException e) {
        return e.getMessage();
    }
}
