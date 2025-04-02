package com.alphacoin.assesment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	 @Autowired
	    private CategoryService categoryService;

	    @GetMapping
	    public ResponseEntity<Page<Category>> getAllCategories(Pageable pageable) {
	        return ResponseEntity.ok(categoryService.getAllCategories(pageable));
	    }

	    @PostMapping
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        return ResponseEntity.ok(categoryService.createCategory(category));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
	        return ResponseEntity.ok(categoryService.getCategoryById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
	        return ResponseEntity.ok(categoryService.updateCategory(id, category));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
	        categoryService.deleteCategory(id);
	        return ResponseEntity.noContent().build();
	    }
}
