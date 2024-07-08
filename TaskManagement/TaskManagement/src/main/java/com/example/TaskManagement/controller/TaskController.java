package com.example.TaskManagement.controller;

import com.example.TaskManagement.models.Task;
import com.example.TaskManagement.service.TaskService;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/createTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
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
        return taskService.updateTaskUsingId(id, task);
    }

    @DeleteMapping(path = "/deleteTask/{id}")
    public void deleteById(@PathVariable int id) {
        taskService.deleteById(id);
    }
}
