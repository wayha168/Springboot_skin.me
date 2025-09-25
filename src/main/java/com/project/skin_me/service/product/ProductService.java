package com.project.skin_me.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.skin_me.exception.ProductNotFoundException;
import com.project.skin_me.model.Category;
import com.project.skin_me.model.Product;
import com.project.skin_me.repository.ProductRepository;
import com.project.skin_me.request.AddProductRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduceService {

    private final ProductRepository productRepository;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Product addProduct(AddProductRequest request) {
        // check if the category is found in DB
       
        return null;

    }

    private Product createProduct(AddProductRequest request, Category category) {
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getProductType(),
                request.getInventory(),
                request.getDescription(),
                category);

    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete, () -> {
                    throw new ProductNotFoundException("Product not found!");
                });
    }

    @Override
    public void updateProduct(Product product, Long productId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByCategory(String category) {

        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByProductType(String productType) {
        return productRepository.findByProductType(productType);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {

        return productRepository.findByCategoryAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public List<Product> getProductsByCategoryAndProductType(String category, String productType) {
        return productRepository.findByCategoryAndProductType(category, productType);
    }

    @Override
    public List<Product> getProductsByProductTypeAndName(String productType, String name) {
        return productRepository.findByProductTypeAndName(productType, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {

        return productRepository.countByBrandAndName(brand, name);
    }

}
