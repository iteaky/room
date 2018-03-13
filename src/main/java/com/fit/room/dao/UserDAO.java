package com.fit.room.dao;

import com.fit.room.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

  public User findByName(String name);
}
