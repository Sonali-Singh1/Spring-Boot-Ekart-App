package com.ekart.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.product.dto.ProductDTO;
import com.ekart.product.exceptions.ProductNotFoundException;
import com.ekart.product.service.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value="/product")
@Validated
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ProductDTO>> getAllProducts() throws ProductNotFoundException {
		List<ProductDTO> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping(value = "/{productId}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer productId) throws ProductNotFoundException {
		ProductDTO product = productService.getProductById(productId);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping(value = "/category")
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@RequestParam String category) throws ProductNotFoundException {
		List<ProductDTO> products = productService.getProductsByCategory(category);
		return ResponseEntity.ok(products);
	}
	
	@PostMapping
	public ResponseEntity<String> addProducts(@RequestBody List<ProductDTO> products){
		System.out.print(products);
		productService.addProducts(products);
		return ResponseEntity.ok("Products added successfully");
	}
}
