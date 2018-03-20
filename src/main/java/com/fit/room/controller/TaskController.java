package com.fit.room.controller;

import com.fit.room.entity.Comment;
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

    @RequestMapping(value = "/task", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Task>> getAllTasks() {

        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }


    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Task> getTask(@PathVariable("taskId") Long taskId) {

        return new ResponseEntity<>(taskService.getTask(taskId), HttpStatus.OK);
    }


    @RequestMapping(value = "/task", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> loadTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/task", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deleteAllTasks() {
        taskService.deleteAllTask();
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{taskId}/comment", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Void> addComentToTask(@PathVariable("taskId") Long taskId,
                                               @RequestBody Comment comment) {
        taskService.addComment(comment, taskId);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
