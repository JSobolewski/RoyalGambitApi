package com.example.royalgambitapi.mapper;

import com.example.royalgambitapi.model.Task;
import com.example.royalgambitapi.model.dto.TaskDto;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto toDto(Optional<Task> entity);

    List<TaskDto> toDtos(List<Task> entities);

    Task toJpa(TaskDto dto);

    @Mapping(target = "id", ignore = true)
    void update(TaskDto dto, @MappingTarget Task entity);
}
