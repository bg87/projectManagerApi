package com.ProjectManager.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Uniqueness validation for the projectIdentifier field cannot be handled in Project entity because uniqueness is
 * handled by the db.
 * */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

    public ProjectIdException(String message) {
        super(message);
    }
}
