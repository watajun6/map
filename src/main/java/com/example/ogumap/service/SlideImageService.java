package com.example.ogumap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ogumap.entity.SlideImage;
import com.example.ogumap.repository.SlideImageRepository;

@Service
public class SlideImageService {

    private final SlideImageRepository slideImageRepository;

    public SlideImageService(SlideImageRepository slideImageRepository) {
        this.slideImageRepository = slideImageRepository;
    }

    public List<SlideImage> getAllSlideImages() {
        return slideImageRepository.findAll();
    }
}