package com.project.skin_me.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.skin_me.model.Category;
import com.project.skin_me.exception.ResourceNotFoundException;
import com.project.skin_me.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found!"));
    }

    @Override
    public Category getCategoryByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryByName'");
    }

    @Override
    public List<Category> getAllCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }

    @Override
    public Category addCategory(Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCategory'");
    }

    @Override
    public Category updateCategory(Category category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updaetCategory'");
    }

    @Override
    public void deleteCategoryById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategoryById'");
    }

}
