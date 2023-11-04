package com.example.royalgambitapi.config;

import com.example.royalgambitapi.model.Task;
import com.example.royalgambitapi.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner_Movies(
            TaskRepository repository) {
        return args -> {
            Task task1 = new Task(1L, "zrob obiad", ZonedDateTime.of(2018, 01, 01, 12, 0, 0, 0, ZoneId.of("UTC")));
            Task task2 = new Task(2L, "zrob kolacje", ZonedDateTime.of(2018, 01, 01, 20, 0, 0, 0, ZoneId.of("UTC")));

            repository.saveAll(
                    List.of(task1, task2)
            );
        };
    }
}
