package com.homerconsulting.hc.controllers;

import com.homerconsulting.hc.bo.AssignmentBO;
import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.services.HomerConsultingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

@RestController
@RequestMapping(path = "/hc/")
public class HCController {

    @Autowired
    private HomerConsultingService homerConsultingService;

    @RequestMapping(path = "project/create/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectBO createProject(@RequestBody ProjectBO projectBO) throws IllegalArgumentException{
        return homerConsultingService.createProject(projectBO);
    }

    @RequestMapping(path = "project/{id}/update", method = RequestMethod.PATCH)
    public ProjectBO updateProject(@PathVariable(name = "id") int id, @RequestParam double totalCost) throws IllegalArgumentException{
        return homerConsultingService.updateProject(id, totalCost);
    }

    @RequestMapping(path = "employee/{id}/assignments")
    public Collection<AssignmentBO> getEmployeeAssignments(@PathVariable(name = "id") int id) throws IllegalArgumentException{
        return homerConsultingService.getEmployeeAssignments(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String catchError(IllegalArgumentException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ParseException.class)
    public String catchError(ParseException e) {
        return e.getMessage();
    }
}
