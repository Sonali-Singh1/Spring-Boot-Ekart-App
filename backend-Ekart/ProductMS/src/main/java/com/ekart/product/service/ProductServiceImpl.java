package com.ekart.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.product.dto.ProductDTO;
import com.ekart.product.entity.Product;
import com.ekart.product.exceptions.ProductNotFoundException;
import com.ekart.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
//	@Autowired
//	private ModelMapper modelMapper;

	@Override
	public List<ProductDTO> getAllProducts() throws ProductNotFoundException {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		products.forEach(product -> productDTOs.add(ProductDTO.prepareProductDTO(product)));
//		productDTOs = products.stream().map(i->modelMapper.map(i, ProductDTO.class)).collect(Collectors.toList());
		if(productDTOs.isEmpty()) {
			throw new ProductNotFoundException("No products found");
		}
		return productDTOs;
	}

	@Override
	public ProductDTO getProductById(Integer productId) throws ProductNotFoundException {
		Optional<Product> productOp = productRepository.findById(productId);
		if(productOp.isEmpty()) {
			throw new ProductNotFoundException("No product found");
		}
		Product product =productOp.get();
//		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		ProductDTO productDTO = ProductDTO.prepareProductDTO(product);
		return productDTO;
	}
	
	@Override
	public List<ProductDTO> getProductsByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategory(category);
		List<ProductDTO> productDTOs = new ArrayList<>();
//		productDTOs = products.stream().map(i->modelMapper.map(i, ProductDTO.class)).collect(Collectors.toList());
		products.forEach(product -> productDTOs.add(ProductDTO.prepareProductDTO(product)));
		if(productDTOs.isEmpty()) {
			throw new ProductNotFoundException("No products found");
		}
		return productDTOs;
	}
	
	@Override
	public void addProducts(List<ProductDTO> productsDTO) {
		List<Product> products = new ArrayList<>();
//		products = productsDTO.stream().map(i->modelMapper.map(i, Product.class)).collect(Collectors.toList());
		productsDTO.forEach(productDTO -> products.add(ProductDTO.prepareProductEntity(productDTO)));
		productRepository.saveAll(products);
	}
	
}
