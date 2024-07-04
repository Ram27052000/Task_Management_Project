package com.example.TaskManagement.service;

import com.example.TaskManagement.models.Task;
import com.example.TaskManagement.repositories.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskUsingId(int id) throws Exception {
        boolean existsByTaskID = taskRepository.existsById(id);
        if(!existsByTaskID){
            throw new Exception("TASK ID NOT FOUND");
        }
        return taskRepository.findById(id);
    }

    public Task  updateTaskUsingId(int id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTaskName(taskDetails.getTaskName());
        task.setPriority(taskDetails.getPriority());
        task.setStatus(taskDetails.getStatus());
        task.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(taskDetails);
    }

    public void deleteById(int id) throws Exception {
        Optional<Task> taskId = taskRepository.findById(id);
        if(taskId.isPresent()){
            taskRepository.deleteById(id);
        }
    }
}
