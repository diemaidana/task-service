package com.devdie.task_service.application.port.in;

import com.devdie.task_service.domain.model.Task;

import java.time.LocalDateTime;
import java.util.UUID;

public interface CreateTaskUseCase {
    Task create(String title, String description, LocalDateTime dueDate, UUID userId);
}
