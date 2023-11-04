package com.example.royalgambitapi.model.response;

import com.example.royalgambitapi.model.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskListResponse {

    private List<TaskDto> content;
}