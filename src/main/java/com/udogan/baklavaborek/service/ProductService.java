package com.udogan.baklavaborek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.udogan.baklavaborek.entity.Product;
import com.udogan.baklavaborek.exception.ProductAlreadyAddedException;
import com.udogan.baklavaborek.exception.ProductNotFoundException;
import com.udogan.baklavaborek.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}
	
	public Product getProduct(Long id) throws ProductNotFoundException {
		Product product = this.productRepository.findOne(id);
		if(product != null)
			return product;
		throw new ProductNotFoundException("Product not found !");
	}
	
	public Product createProduct(Product product) throws Exception {
		if(checkProductAddedBefore(product.getName()))
			return this.productRepository.saveAndFlush(product);
		throw new ProductAlreadyAddedException("Product added before !");
	}
	
	public Product updateProduct(Product product) throws Exception {
		Assert.notNull(product.getId(),"Product id cannot be null!");
		if(checkProductAddedBefore(product.getName(),product.getId()))
			return this.productRepository.saveAndFlush(product);
		throw new ProductAlreadyAddedException("Product added before !");
	}

	public boolean deleteProduct(Long id) throws ProductNotFoundException {
		Product product = getProduct(id);
		this.productRepository.delete(product);
		return true;
	}
	
	private boolean checkProductAddedBefore(String name) {
		return checkProductAddedBefore(name , null);
	}

	private boolean checkProductAddedBefore(String name, Long id) {
		Product product = this.productRepository.findByName(name);
		return product != null && product.getId() != null ? product.getId().equals(id) : true;
	}
}