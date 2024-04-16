package com.matheusob25.projetoweb.repositories;

import com.matheusob25.projetoweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
