package com.projectMicroservice.state;

import com.projectMicroservice.entities.Project;
import com.projectMicroservice.entities.ProjectStatus;

public class PendingState implements IProjectState {

    private Project project;

    @Override
    public void approve(Project project) throws Exception{
        project.setState(new ApprovedState());
        project.setStatus(ProjectStatus.APPROVED);
    }

    @Override
    public void reject(Project project) throws Exception{
        project.setState(new RejectedState());
        project.setStatus(ProjectStatus.REJECTED);
    }

    @Override
    public void assign(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Assigned\" from \"Pending\"");
    }

    @Override
    public void complete(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Completed\" from \"Pending\"");
    }

}
