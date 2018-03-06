package com.fit.room.dao;

import com.fit.room.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotoDAO extends JpaRepository<Photo, Long> {
}