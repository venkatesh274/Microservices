package com.example.OrderServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderServices.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
