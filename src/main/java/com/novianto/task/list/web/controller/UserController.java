package com.novianto.task.list.web.controller;

import com.novianto.task.list.domain.task.Task;
import com.novianto.task.list.domain.user.User;
import com.novianto.task.list.service.TaskService;
import com.novianto.task.list.service.UserService;
import com.novianto.task.list.web.dto.task.TaskDto;
import com.novianto.task.list.web.dto.user.UserDto;
import com.novianto.task.list.web.dto.validation.OnCreate;
import com.novianto.task.list.web.dto.validation.OnUpdate;
import com.novianto.task.list.web.mappers.TaskMapper;
import com.novianto.task.list.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updateUser = userService.update(user);
        return userMapper.toDto(updateUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTaskByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task createTask = taskService.create(task, id);
        return taskMapper.toDto(createTask);
    }

}
