package com.devdie.task_service.domain.model;

import com.devdie.task_service.domain.exception.DateNotValidException;
import com.devdie.task_service.domain.exception.TaskCompletedOrExpiredException;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskStatus taskStatus;
    private UUID userId;

    public Task() {
        taskStatus = TaskStatus.PENDIENTE;
    }

    public Task(UUID id, String title, String description, LocalDateTime dueDate, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        if(dueDate.isBefore(LocalDateTime.now())){
            throw new DateNotValidException();
        }
        this.dueDate = dueDate;
        this.userId = userId;
        taskStatus = TaskStatus.PENDIENTE;
    }

    public Task(UUID id, String title, String description, LocalDateTime dueDate, TaskStatus taskStatus, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
        this.userId = userId;
    }

   public boolean markAsCompleted() {
        if(!taskStatus.equals(TaskStatus.PENDIENTE)){
            throw new TaskCompletedOrExpiredException("La tarea ya fue completada o esta vencida.");
        }

       taskStatus = TaskStatus.REALIZADA;
       return true;
   }
}
