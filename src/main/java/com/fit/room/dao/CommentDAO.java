package com.fit.room.dao;


import com.fit.room.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {
}