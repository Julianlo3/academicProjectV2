package com.projectMicroservice.state;


import com.projectMicroservice.entities.Project;
import com.projectMicroservice.entities.ProjectStatus;

public class AssignedState implements IProjectState {

    @Override
    public void approve(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Approved\" from \"Assigned\"");
    }

    @Override
    public void reject(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Rejected\" from \"Assigned\"");
    }

    @Override
    public void assign(Project project) throws Exception{
        throw new IllegalAccessException("The project has already been \"Assigned\"");
    }

    @Override
    public void complete(Project project) throws Exception{
        project.setState(new CompletedState());
        project.setStatus(ProjectStatus.COMPLETED);
    }

}
