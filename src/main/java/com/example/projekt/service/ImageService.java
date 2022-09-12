package com.example.projekt.service;

import com.example.projekt.model.Image;
import com.example.projekt.model.ImageForm;
import com.example.projekt.model.Insegnante;
import com.example.projekt.repository.ImageRepository;
import com.example.projekt.repository.InsegnantiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imgRepo;

    @Autowired
    private InsegnantiRepository insRepo;

    public List<Image> getImagesByInsId(Integer insId) {
        Insegnante insegnante = insRepo.findById(insId).get();
        return imgRepo.findByInsegnante(insegnante);
    }

    public ImageForm newImgForm(){
        ImageForm imgform = new ImageForm();
        return imgform;
    }

    public Image newImage (ImageForm imgForm) throws IOException {
        Image imgSave = new Image();
        imgSave.setInsegnante(imgForm.getInsegnante());
        if (imgForm.getContentMultipart() != null) {
            byte[] contentSerialized = imgForm.getContentMultipart().getBytes();
            imgSave.setContent(contentSerialized);
        }
        return imgRepo.save(imgSave);
    }

    public byte[] getImageContent(Integer id) {
        Image img = imgRepo.findById(id).get();
        return img.getContent();
    }
}
