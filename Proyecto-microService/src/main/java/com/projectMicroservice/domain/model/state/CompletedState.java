package com.projectMicroservice.domain.model.state;

import com.projectMicroservice.infraestructure.Project;

public class CompletedState implements IProjectState {

    @Override
    public void approve(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Approved\" from \"Completed\"");
    }

    @Override
    public void reject(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Rejected\" from \"Completed\"");
    }

    @Override
    public void assign(Project project) throws Exception{
        throw new IllegalAccessException("The project cannot change to \"Assigned\" from \"Completed\"");
    }

    @Override
    public void complete(Project project) throws Exception{
        throw new IllegalAccessException("The project has already been \"Completed\"");
    }

}
