package com.projectMicroservice.domain.state;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectTimeline;

import java.math.BigDecimal;

public class Rejected implements IProjectState {

    @Override
    public void approve(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Approved\" from \"Rejected\"");
    }

    @Override
    public void reject(Project project) throws Exception{
        throw new IllegalAccessException("The project has already been \"Rejected\"");
    }

    @Override
    public void assign(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Assigned\" from \"Rejected\"");
    }

    @Override
    public void complete(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Completed\" from \"Rejected\"");
    }

    @Override
    public void editDetails(Project project, ProjectDetails newDetails) throws Exception {
        throw new IllegalAccessException("Details cannot be changed if the project is \"Rejected\".");
    }

    @Override
    public void editTimeline(Project project, ProjectTimeline newTimeline) throws Exception {
        throw new IllegalAccessException("Timeline cannot be changed if the project is \"Rejected\".");
    }

    @Override
    public void editBudget(Project project, BigDecimal newBudget) throws Exception {
        throw new IllegalAccessException("Budget cannot be changed if the project is \"Rejected\".");
    }
}
