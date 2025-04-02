package com.alphacoin.assesment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	 @Autowired
	 public CategoryRepository categoryRepository;
	 
	 public Page<Category> getAllCategories(Pageable pageable) {
	     return categoryRepository.findAll(pageable);
	 }
	 
	 
     public Category getCategoryById(int id) {
	     return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
     }

	 public Category createCategory(Category category) {
		 return categoryRepository.save(category);
     }
	
	 public Category updateCategory(int id, Category categoryDetails) {
		 Category category = getCategoryById(id);
		 category.setName(categoryDetails.getName());
		 return categoryRepository.save(category);
     }
	
	 public void deleteCategory(int id) {
		 categoryRepository.deleteById(id);
	 }
}
