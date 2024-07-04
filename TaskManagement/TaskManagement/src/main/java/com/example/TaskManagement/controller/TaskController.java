package com.example.TaskManagement.controller;

import com.example.TaskManagement.models.Task;
import com.example.TaskManagement.repositories.TaskRepository;
import com.example.TaskManagement.service.TaskService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/task/{id}")
    public Optional<Task> getTaskUsingId(@PathVariable int id) throws Exception {
        return taskService.getTaskUsingId(id);
    }

    @PutMapping(path = "/updateTask/{id}")
    public Task updateTaskUsingId(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTaskUsingId(id,task);
    }

    @DeleteMapping(path="/deleteTask/{id}")
    public void deleteById(@PathVariable int id) throws Exception{
        taskService.deleteById(id);
    }
}
