package com.project.skin_me.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.skin_me.exception.ProductNotFoundException;
import com.project.skin_me.model.Category;
import com.project.skin_me.model.Product;
import com.project.skin_me.repository.CategoryRepository;
import com.project.skin_me.repository.ProductRepository;
import com.project.skin_me.request.AddProductRequest;
import com.project.skin_me.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduceService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Product addProduct(AddProductRequest request) {
        // check if the category is found in DB
        Category category = Optional.ofNullable(categoryRepository.findByname(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        request.setCategory(category);
        return productRepository.save(createProduct(request, category));

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
    public Product updateProduct(ProductUpdateRequest request, Long productId) {
       return productRepository.findById(productId)
       .map(existingProduct -> updateExistingProduct(existingProduct, request))
       .map(productRepository :: save)
       .orElseThrow(() -> new ProductNotFoundException("Product not found!!"));
    }

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request){
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setProductType(request.getProductType());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category = categoryRepository.findByname(request.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;
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
