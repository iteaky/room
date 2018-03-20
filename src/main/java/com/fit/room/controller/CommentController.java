package com.fit.room.controller;

import com.fit.room.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/comment/{comentId}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deleteComment(@PathVariable("comentId") Long comentId) {
        commentService.deleteComment(comentId);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
