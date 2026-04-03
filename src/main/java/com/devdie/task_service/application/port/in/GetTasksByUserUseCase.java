package com.devdie.task_service.application.port.in;

import com.devdie.task_service.domain.model.Task;

import java.util.List;
import java.util.UUID;

public interface GetTasksByUserUseCase {
    List<Task> getTasksByUserId(UUID userId);
}
