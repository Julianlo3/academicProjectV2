package com.projectMicroservice.domain.state;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.*;

/**
 *
 * Interface que maneja el ciclo de vida del proyecto
 */
public interface IProjectState {

    void approve(Project project) throws Exception;

    void reject(Project project) throws Exception;

    void assign(Project project) throws Exception;

    void complete(Project project) throws Exception;

    void editDetails(Project project, ProjectDetails newDetails) throws Exception;

    void updateRequirements(Project project, ProjectRequirements newRequirements) throws Exception;

    void updateTechnologyStack(Project project, TechnologyStack newStack) throws Exception;
}
