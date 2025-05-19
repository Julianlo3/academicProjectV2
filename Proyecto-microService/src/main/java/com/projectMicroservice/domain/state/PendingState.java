package com.projectMicroservice.domain.state;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectRequirements;
import com.projectMicroservice.domain.valueObject.TechnologyStack;

public class PendingState implements IProjectState {

    private Project project;

    @Override
    public void approve(Project project) throws Exception{
        project.changeState(new ApprovedState());
    }

    @Override
    public void reject(Project project) throws Exception{
        project.changeState(new RejectedState());
    }

    @Override
    public void assign(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Assigned\" from \"Pending\"");
    }

    @Override
    public void complete(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Completed\" from \"Pending\"");
    }

    @Override
    public void editDetails(Project project, ProjectDetails newDetails) throws Exception {
        project.applyDetailsChange(newDetails);
    }

    @Override
    public void updateRequirements(Project project, ProjectRequirements newRequirements) throws Exception {
        project.applyRequirementsChange(newRequirements);
    }

    @Override
    public void updateTechnologyStack(Project project, TechnologyStack newStack) throws Exception {
        project.applyTechnologyStackChange(newStack);
    }

}
