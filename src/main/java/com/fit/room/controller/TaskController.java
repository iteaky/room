package com.fit.room.controller;

import com.fit.room.entity.Task;
import com.fit.room.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }
    @PostMapping("/tasks")
    public ResponseEntity<Void> loadTask(Task task){
        taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
