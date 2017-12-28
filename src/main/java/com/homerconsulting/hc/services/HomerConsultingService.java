package com.homerconsulting.hc.services;

import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.model.Employee;

import java.text.ParseException;

public interface HomerConsultingService {

    ProjectBO createProject(ProjectBO projectBO) throws IllegalArgumentException, ParseException;
}
