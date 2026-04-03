package com.devdie.task_service.application.port.in;

import com.devdie.task_service.domain.model.Task;

import java.util.UUID;

public interface CompleteTaskUseCase {
    Task completeTask(UUID taskId);
}
