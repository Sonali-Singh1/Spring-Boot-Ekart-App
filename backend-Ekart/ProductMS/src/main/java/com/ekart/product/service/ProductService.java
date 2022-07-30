package com.ekart.product.service;

import java.util.List;

import com.ekart.product.dto.ProductDTO;
import com.ekart.product.exceptions.ProductNotFoundException;

public interface ProductService {
	List<ProductDTO> getAllProducts() throws ProductNotFoundException;
	ProductDTO getProductById(Integer productId) throws ProductNotFoundException;
	List<ProductDTO> getProductsByCategory(String category) throws ProductNotFoundException;
    void addProducts(List<ProductDTO> products);
}
