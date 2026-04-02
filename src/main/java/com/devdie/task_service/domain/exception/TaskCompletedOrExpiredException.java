package com.devdie.task_service.domain.exception;

public class TaskCompletedOrExpiredException extends RuntimeException {
    public TaskCompletedOrExpiredException(String message) {
        super(message);
    }
}
