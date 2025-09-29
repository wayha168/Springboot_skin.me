package com.project.skin_me.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.skin_me.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByProductId(Long id);

}
