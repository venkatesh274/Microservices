package com.example.OrderServices.DToEntity;

public class Product {

	
	private Long id;
	private String productName;
	private Long price;
	
	public Product() {
		super();
	}
	public Product(Long id, String productName, Long price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
	
	
	
}
