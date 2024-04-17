package com.matheusob25.projetoweb.repositories;

import com.matheusob25.projetoweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
