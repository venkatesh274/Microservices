package com.example.OrderServices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderServices.Entity.Orders;
import com.example.OrderServices.Repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRepository orderRepository;

	public Orders updateOrder(Long id) {

		Optional<Orders> order = orderRepository.findById(id);
		if (order.isPresent()) {
			Orders orders = order.get();
			orders.setOrderName("FINSERVE");
			return orderRepository.save(orders);
		}

		return null;

	}
	
	

}
