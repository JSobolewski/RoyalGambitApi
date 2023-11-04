package com.example.royalgambitapi.controller;

import com.example.royalgambitapi.exception.ErrorCode;
import com.example.royalgambitapi.exception.TaskException;
import com.example.royalgambitapi.mapper.TaskMapper;
import com.example.royalgambitapi.model.Task;
import com.example.royalgambitapi.model.dto.TaskDto;
import com.example.royalgambitapi.model.response.TaskListResponse;
import com.example.royalgambitapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @GetMapping
    public TaskListResponse getAll() {
        List<Task> taskList = taskRepository.findAll();

        return new TaskListResponse(taskMapper.toDtos(taskList));
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Optional<Task> task = taskRepository.findById(id);

        return taskMapper.toDto(task);
    }

    @PostMapping
    public void add(@RequestBody TaskDto taskDto) {
        Task task = TaskMapper.INSTANCE.toJpa(taskDto);

        taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public void put(@RequestBody TaskDto taskDto, Long id) {

        Task task = taskRepository.findById(taskDto.getId())
                .orElseThrow(() -> new TaskException(ErrorCode.NOT_FOUND));

        TaskMapper.INSTANCE.update(taskDto, task);

        taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {

        taskRepository.deleteById(id);
    }
}
