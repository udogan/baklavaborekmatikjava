package com.udogan.baklavaborek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udogan.baklavaborek.entity.Product;
import com.udogan.baklavaborek.exception.ProductNotFoundException;
import com.udogan.baklavaborek.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Product> getAllProduct() {
		return this.productService.getProducts();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
		return this.productService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) throws Exception {
		return this.productService.createProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Product editProduct(@RequestBody Product product) throws Exception {
		return this.productService.updateProduct(product);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public boolean deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
		return this.productService.deleteProduct(id);
	}
}