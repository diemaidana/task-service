package com.devdie.task_service.application.port.out;

import com.devdie.task_service.domain.model.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(UUID id);
    List<Task> findTasksByUserId(UUID userId);
    List<Task> findPendingTasksWithDueDateBefore(LocalDateTime date);
}
