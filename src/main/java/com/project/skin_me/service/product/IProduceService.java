package com.project.skin_me.service.product;

import java.util.List;

import com.project.skin_me.model.Product;
import com.project.skin_me.request.AddProductRequest;

public interface IProduceService {
    Product addProduct(AddProductRequest request);

    Product getProductById(Long id);

    void deleteProductById(Long id);

    void updateProduct(Product product, Long productId);

    List<Product> getAllProducts();

    List<Product> getAllProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByProductType(String productType);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByCategoryAndProductType(String category, String productType);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    List<Product> getProductsByProductTypeAndName(String productType, String name);

    Long countProductsByBrandAndName(String brand, String name);

}
