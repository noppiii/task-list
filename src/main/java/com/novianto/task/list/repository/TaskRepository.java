package com.novianto.task.list.repository;

import com.novianto.task.list.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Long id);
    List<Task> findAllByUserId(Long userId);
    void assignToUserById(Long taskUd, Long userId);
    void update(Task task);
    void create(Task task);
    void delete(Long id);
}
