package com.fit.room.service;

import com.fit.room.dao.PhotoDAO;
import com.fit.room.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Autowired
    private PhotoDAO photoDAO;


    public Long increaseLike(Long photoId) {
        Photo one = photoDAO.getOne(photoId);
        long incrementAndGet = one.getLikeCount().incrementAndGet();
        photoDAO.save(one);
        return incrementAndGet;
    }
}
