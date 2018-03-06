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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createTestTask() {
        Task task = new Task();
        Photo photo = new Photo();
        Comment comment = new Comment();
        photo.setImageURI("http://imagehost/ig/1221.jpg");
        photo.setLikeCount(999L);
        task.setPhotos(Collections.singletonList(photo));
        comment.setCreationDate(LocalDateTime.now());
        comment.setText("best!");
        task.setComments(Collections.singletonList(comment));
        photoDAO.save(photo);
        commentDAO.save(comment);
        taskDAO.save(task);

    }


}
