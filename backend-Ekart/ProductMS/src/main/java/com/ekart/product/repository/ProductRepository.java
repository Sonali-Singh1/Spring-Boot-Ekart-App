package com.ekart.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product> findByCategory(String category);
}
