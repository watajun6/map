package com.example.ogumap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ogumap.entity.SlideImage;

@Repository
public interface SlideImageRepository extends JpaRepository<SlideImage, Long> {
}