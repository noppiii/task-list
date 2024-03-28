package com.novianto.task.list.web.mappers;

import com.novianto.task.list.domain.task.Task;
import com.novianto.task.list.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);
    List<TaskDto> toDto(List<Task> tasks);
    Task toEntity(TaskDto taskDto);
}
