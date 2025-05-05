package com.projectMicroservice.state;

import com.projectMicroservice.entities.Project;

public class RejectedState implements IProjectState {

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

}
