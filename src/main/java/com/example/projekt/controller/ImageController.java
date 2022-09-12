package com.example.projekt.controller;

import com.example.projekt.model.Image;
import com.example.projekt.model.ImageForm;
import com.example.projekt.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService service;

//    @GetMapping("/{iId}")
//    public String InsImages(@PathVariable("iId") Integer iId, Model m) {
//
//        List<Image> images = service.getImagesByInsId(iId);
//
//
//        m.addAttribute("imageList", images);
//        return "imglist";
//    }

    @PostMapping("/save")
    public String saveImage(@ModelAttribute("imageForm") ImageForm imageForm) {
//        try {
//            Image savedImage = service.newImage(imageForm);
//            return "redirect:/";
//        } catch (IOException e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to save image");
//        }
        return "";
    }

    @RequestMapping(value = "/{imageId}/content", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageContent(@PathVariable("imageId") Integer imageId) {
        byte[] content = service.getImageContent(imageId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
    }
}
