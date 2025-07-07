package com.example.OrderServices.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.OrderServices.DToEntity.Product;

@FeignClient(url = "http://localhost:8083", name = "PRODUCTSERVICE", path = "/products")
public interface OrderFeign {

	@GetMapping("/{id}")
	Product getProductById(@PathVariable Long id);

	@PostMapping
	void save(Product product);

	@DeleteMapping("/delete/{id}")
	String deleteProductById(@PathVariable Long id);
}
