package com.project.skin_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.skin_me.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByname(String name);

    boolean existsByName(String name);

}
