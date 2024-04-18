package com.matheusob25.projetoweb.repositories;

import com.matheusob25.projetoweb.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
