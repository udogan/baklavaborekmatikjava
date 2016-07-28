package com.udogan.baklavaborek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udogan.baklavaborek.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAll();
	Product findOne(Long id);
	<S extends Product> S saveAndFlush(S product);
	void delete (Product product);
	Product findByName(String name);
}