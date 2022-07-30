package com.ekart.product.exceptions;

public class ProductNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String errors) {
		super(errors);
	}
}
