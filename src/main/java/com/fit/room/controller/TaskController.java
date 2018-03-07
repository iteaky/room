package com.fit.room.controller;

import com.fit.room.entity.Task;
import com.fit.room.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<List<Task>> getAllTasks() {

        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }


    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<Task> getTask(@PathVariable("taskId") Long taskId) {

        return new ResponseEntity<>(taskService.getTask(taskId), HttpStatus.OK);
    }



    @RequestMapping(value = "/loadTask", method = RequestMethod.POST, consumes = "application/json", produces = "application/json" )
    public ResponseEntity<Void> loadTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
