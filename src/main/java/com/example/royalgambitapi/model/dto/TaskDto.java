package com.example.royalgambitapi.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class TaskDto {


    private Long id;

    private String content;

    private ZonedDateTime creationDate;

}
