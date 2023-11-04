package com.example.royalgambitapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table("tasks")
@AllArgsConstructor
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    @Column(name = "task_id", unique = true, nullable = false)
    private Long id;

    private String content;

    private ZonedDateTime creationDate;
}
