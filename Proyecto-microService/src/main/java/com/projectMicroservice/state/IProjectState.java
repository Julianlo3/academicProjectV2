package com.projectMicroservice.state;

import com.projectMicroservice.entities.Project;

/**
 *
 * Interface que maneja el ciclo de vida del proyecto
 */
public interface IProjectState {

    void approve(Project project) throws Exception;

    void reject(Project project) throws Exception;

    void assign(Project project) throws Exception;

    void complete(Project project) throws Exception;
}
