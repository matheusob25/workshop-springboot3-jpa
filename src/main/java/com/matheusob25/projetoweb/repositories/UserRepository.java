package com.matheusob25.projetoweb.repositories;

import com.matheusob25.projetoweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// interface que conecta com o banco e persiste os dados
public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository recebe a entidade e o tipo do id da entidade para criar os métodos
    //a interface fica vazia porque os métodos são herdados da super classe

    // muitos métodos básicos de CRUD vem prontos da super classe extendida, mas como dito antes,
    // é possível customizar querys com oque for necessário
    // nesse caso eu queria buscar um usuário pelo email dele, então fiz o SQL pela anotação @Query
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
