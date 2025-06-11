package com.projectMicroservice.domain.state;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectTimeline;

import java.math.BigDecimal;

public class Received implements IProjectState {

    private Project project;

    @Override
    public void approve(Project project) throws Exception{
        project.changeState(new Approved());
    }

    @Override
    public void reject(Project project) throws Exception{
        project.changeState(new Rejected());
    }

    @Override
    public void assign(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Assigned\" from \"Received\"");
    }

    @Override
    public void complete(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Completed\" from \"Received\"");
    }

    @Override
    public void editDetails(Project project, ProjectDetails newDetails) throws Exception {
        project.applyDetailsChange(newDetails);
    }

    @Override
    public void editTimeline(Project project, ProjectTimeline newTimeline) throws Exception {
        project.applyTimelineChange(newTimeline);
    }

    @Override
    public void editBudget(Project project, BigDecimal newBudget) throws Exception {
        project.applyBudgetChange(newBudget);
    }


}
