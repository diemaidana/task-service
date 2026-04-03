package com.devdie.task_service.application.service;

import com.devdie.task_service.application.port.in.CheckOverdueTasksUseCase;
import com.devdie.task_service.application.port.in.CompleteTaskUseCase;
import com.devdie.task_service.application.port.in.CreateTaskUseCase;
import com.devdie.task_service.application.port.in.GetTasksByUserUseCase;
import com.devdie.task_service.application.port.out.TaskRepository;
import com.devdie.task_service.domain.exception.TaskNotFoundException;
import com.devdie.task_service.domain.model.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TaskService implements
        CreateTaskUseCase,
        CompleteTaskUseCase,
        GetTasksByUserUseCase,
        CheckOverdueTasksUseCase {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void checkOverdueTasks() {
        List<Task> expiredTasks = taskRepository.findPendingTasksWithDueDateBefore(LocalDateTime.now());
        expiredTasks.forEach(Task::markAsExpired);
        expiredTasks.forEach(taskRepository::save);
    }

    @Override
    public Task completeTask(UUID taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("No se encuentra la tarea."));

        task.markAsCompleted();
        return taskRepository.save(task);
    }

    @Override
    public Task create(String title, String description, LocalDateTime dueDate, UUID userId) {
        Task task = new Task(
                UUID.randomUUID(),
                title,
                description,
                dueDate,
                userId
        );

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByUserId(UUID userId) {
        return taskRepository.findTasksByUserId(userId);
    }
}
