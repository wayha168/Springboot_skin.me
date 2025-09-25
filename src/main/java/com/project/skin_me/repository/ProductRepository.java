package com.project.skin_me.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.skin_me.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByCategoryAndBrand(String category, String brand);

    List<Product> findByBrandAndName(String brand, String name);

    List<Product> findByCategoryAndProductType(String category, String productType);

    List<Product> findByName(String name);

    List<Product> findByProductType(String productType);

    List<Product> findByProductTypeAndName(String productType, String name);

    Long countByBrandAndName(String brand, String name);

}
