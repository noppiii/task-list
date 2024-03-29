package com.novianto.task.list.service;

import com.novianto.task.list.domain.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);
    List<Task> getAllByUserId(Long id);
    Task update(Task task);
    Task create(Task task, Long userId);
    void delete(Long id);
}
