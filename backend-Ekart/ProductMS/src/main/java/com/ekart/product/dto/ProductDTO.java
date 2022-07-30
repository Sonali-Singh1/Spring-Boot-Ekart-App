package com.ekart.product.dto;

import com.ekart.product.entity.Product;

public class ProductDTO {
	
	public Integer id;
	private String title;
	private String description;
	private String category;
	private String image;
	private Double price;
	private Integer discount;
	private Double rating;
	private Integer noOfReviews;
	
	public static Product prepareProductEntity(ProductDTO productDTO)
	{
		Product productEntity = new Product();
		productEntity.setId(productDTO.getId());
		productEntity.setTitle(productDTO.getTitle());
		productEntity.setDescription(productDTO.getDescription());
		productEntity.setCategory(productDTO.getCategory());
		productEntity.setImage(productDTO.getImage());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setDiscount(productDTO.getDiscount());
		productEntity.setRating(productDTO.getRating());
		productEntity.setNoOfReviews(productDTO.getNoOfReviews());
		return productEntity;
	}
	
	public static ProductDTO prepareProductDTO(Product product)
	{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setTitle(product.getTitle());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategory(product.getCategory());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setDiscount(product.getDiscount());
		productDTO.setRating(product.getRating());
		productDTO.setNoOfReviews(product.getNoOfReviews());
		return productDTO;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", image=" + image + ", price=" + price + ", discount=" + discount + ", rating=" + rating
				+ ", noOfReviews=" + noOfReviews + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getNoOfReviews() {
		return noOfReviews;
	}

	public void setNoOfReviews(Integer noOfReviews) {
		this.noOfReviews = noOfReviews;
	}
	
}
