package com.matheusob25.projetoweb.repositories;

import com.matheusob25.projetoweb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
