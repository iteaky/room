package com.fit.room.service;

import com.fit.room.dao.CommentDAO;
import com.fit.room.dao.PhotoDAO;
import com.fit.room.dao.TaskDAO;
import com.fit.room.entity.Comment;
import com.fit.room.entity.Photo;
import com.fit.room.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskDAO taskDAO;
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private PhotoDAO photoDAO;

    public void addTask(Task task) {
        task.getPhotos().forEach(photo -> photoDAO.save(photo));
        task.getComments().forEach(comment -> commentDAO.save(comment));
        taskDAO.save(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }

    public Task getTask(Long id) {
        return taskDAO.getOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createTestTask() {
        Task task = new Task();
        Photo photo = new Photo();
        Comment comment = new Comment();
        photo.setImageURI("/photos/1.jpg");
        photo.setLikeCount(new AtomicLong(100));
        task.setPhotos(Collections.singletonList(photo));
        comment.setCreationDate(LocalDateTime.now());
        comment.setText("best!");
        task.setComments(Collections.singletonList(comment));
        task.setSub("which one?");
        photoDAO.save(photo);
        commentDAO.save(comment);
        taskDAO.save(task);

    }


    public void deleteAllTask() {
        taskDAO.deleteAll();
    }


    public void addComment(Comment comment, Long taskId) {
        taskDAO.findById(taskId).ifPresent(task -> task.getComments().add(comment));
    }
}
