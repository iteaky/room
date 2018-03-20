package com.fit.room.controller;

import com.fit.room.service.ImageService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;


    @ApiImplicitParam(name = "id", value = "photo id", required = true, dataType = "long", paramType = "path")
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET, produces = "image/jpg")
    public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Long photoId) throws IOException {
        return new ResponseEntity<>(imageService.getImage(photoId), HttpStatus.OK);
    }

    @RequestMapping(value = "/photo", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
    public ResponseEntity<String> loadPhoto(@RequestBody MultipartFile file) throws IOException {
        return new ResponseEntity<>(imageService.addImage(file), HttpStatus.OK);
    }

    @RequestMapping(value = "/2photo", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
    public ResponseEntity<List<String>> loadPhoto(@RequestBody MultipartFile file1, @RequestBody MultipartFile file2) throws IOException {
        return new ResponseEntity<>(imageService.addImage(file1, file2), HttpStatus.OK);
    }


}

