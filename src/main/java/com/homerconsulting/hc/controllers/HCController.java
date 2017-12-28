package com.homerconsulting.hc.controllers;

import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.services.HomerConsultingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(path = "/hc/createProject")
public class HCController {

    @Autowired
    private HomerConsultingService homerConsultingService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectBO createProject(@RequestBody ProjectBO projectBO) throws IllegalArgumentException, ParseException{
        return homerConsultingService.createProject(projectBO);
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
