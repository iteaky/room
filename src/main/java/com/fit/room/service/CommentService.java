package com.fit.room.service;

import com.fit.room.dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentDAO commentDAO;

    public void deleteComment(Long comentId) {
        commentDAO.deleteById(comentId);
    }
}
