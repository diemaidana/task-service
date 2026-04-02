package com.devdie.task_service.domain.exception;

public class DateNotValidException extends RuntimeException {
    public DateNotValidException() {
        super("La fecha de vencimiento no puede ser anterior a la fecha actual.");
    }
}
