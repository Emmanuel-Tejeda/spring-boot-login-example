package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.ImageModel;
import com.bezkoder.spring.login.repository.ImageJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;


@Service
public class ImageService {

    @Autowired
    private ImageJpa ImageModelRepository;

    public ImageModel store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageModel ImageModel = new ImageModel(fileName, file.getContentType(), file.getBytes());

        return ImageModelRepository.save(ImageModel);
    }

    public ImageModel getFile(String id) {
        return ImageModelRepository.findById(id).get();
    }

    public Stream<ImageModel> getAllFiles() {
        return ImageModelRepository.findAll().stream();
    }

    public void deleteFile(String id){ ImageModelRepository.deleteById(id);}
}

