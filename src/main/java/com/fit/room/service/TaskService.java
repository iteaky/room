package com.fit.room.service;

import com.fit.room.dao.TaskDAO;
import com.fit.room.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskDAO taskDAO;

    public void addTask(Task task) {
        taskDAO.save(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }


}
