package com.example.OrderServices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderServices.DToEntity.Product;
import com.example.OrderServices.Entity.Orders;
import com.example.OrderServices.FeignClient.OrderFeign;
import com.example.OrderServices.Repository.OrderRepository;
import com.example.OrderServices.service.OrderServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderFeign orderFeign;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderServices orderServices;

	@PostMapping("/save")
	public void saveOrder(@RequestBody Orders orders) {
		orderRepository.save(orders);
		System.out.println("Order saved into table succesfully..");
	}

	@PostMapping
	public void createOrder(@RequestBody Product product) {
		orderFeign.save(product);
		System.out.println("product added through order services..");
	}

	@GetMapping("/{id}")
	@CircuitBreaker(name = "PRODUCTSERVICE", fallbackMethod = "fallbackMethod")
	public Product getProductByOrderId(@PathVariable Long id) {
		System.out.println("order service is accessiong");
		
		Product productById = orderFeign.getProductById(id);
		return productById;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		String deleteProductById = orderFeign.deleteProductById(id);
		return deleteProductById;
	}
	
	@PutMapping("/update/{id}")
	public Orders updateOrders(@PathVariable Long id) {
		Orders updateOrder = orderServices.updateOrder(id);
		return updateOrder;
	}
	
	public String fallbackMethod(Long id, Throwable t) {
        return "Product Service is currently unavailable. Please try again later.";
    }
	
	

}
