package com.fit.room.controller;

import com.fit.room.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/photo/{photoId}/like", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Long> increaseLike(@PathVariable("photoId") Long photoId) {

        return new ResponseEntity<>(photoService.increaseLike(photoId), HttpStatus.OK);
    }

}
