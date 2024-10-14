package com.techrevolution.ms.orderservice.repository;

import com.techrevolution.ms.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {
}
