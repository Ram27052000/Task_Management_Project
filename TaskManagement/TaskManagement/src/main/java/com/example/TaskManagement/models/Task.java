package com.example.TaskManagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence_generator")
    @SequenceGenerator(name = "task_sequence_generator", allocationSize = 1)
    private int taskId;

    @NonNull
    private String taskName;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

}
