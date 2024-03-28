package com.novianto.task.list.web.controller;

import com.novianto.task.list.domain.task.Task;
import com.novianto.task.list.service.TaskService;
import com.novianto.task.list.web.dto.task.TaskDto;
import com.novianto.task.list.web.dto.validation.OnUpdate;
import com.novianto.task.list.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updateTask = taskService.update(task);
        return taskMapper.toDto(updateTask);
    }

    @GetMapping("/{id}")
    public TaskDto geyById(Long id){
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id){
        taskService.delete(id);
    }
}
