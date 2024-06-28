package com.example.TaskManagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "task_sequence_generator")
    @SequenceGenerator(name="task_sequence_generator", allocationSize = 1)
    private int taskId;

    @NonNull
    private String taskName;

    private boolean status;

    private String priority;

    @ManyToOne
    @JoinColumn(name="parent_task_id", nullable = true)
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask")
    private List<Task> subtasks;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id", nullable = true)
    private User user;

}
