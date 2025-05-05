package com.projectMicroservice.state;


import com.projectMicroservice.entities.Project;
import com.projectMicroservice.entities.ProjectStatus;

public class ApprovedState implements IProjectState {

    @Override
    public void approve(Project project)  throws Exception{
        throw new IllegalAccessException("The project has already been \"Approved\"");
    }

    @Override
    public void reject(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Rejected\" from \"Approved\"");
    }

    @Override
    public void assign(Project project) throws Exception{
        project.setState(new AssignedState());
        project.setStatus(ProjectStatus.ASSIGNED);
    }

    @Override
    public void complete(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Completed\" from \"Approved\"");
    }

}
