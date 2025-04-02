package com.alphacoin.assesment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	 @Autowired
	    public ProductRepository productRepository;

	    public Page<Product> getAllProducts(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }

	    public Product getProductById(int id) {
	        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Product updateProduct(int id, Product productDetails) {
	        Product product = getProductById(id);
	        product.setName(productDetails.getName());
	        product.setCategory(productDetails.getCategory());
	        return productRepository.save(product);
	    }
	    public void deleteProduct(int id) {
	    	productRepository.deleteById(id);
	    }
}
