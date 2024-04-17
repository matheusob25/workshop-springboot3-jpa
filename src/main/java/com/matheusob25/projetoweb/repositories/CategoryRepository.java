package com.matheusob25.projetoweb.repositories;

import com.matheusob25.projetoweb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
