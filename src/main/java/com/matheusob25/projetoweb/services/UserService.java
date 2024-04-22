package com.matheusob25.projetoweb.services;

import com.matheusob25.projetoweb.entities.User;
import com.matheusob25.projetoweb.repositories.UserRepository;
import com.matheusob25.projetoweb.services.exceptions.ResourceNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User user){
       return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public User update(Long id,User user){
        User entitiy = userRepository.getReferenceById(id);
        updateData(entitiy, user);
        return userRepository.save(entitiy);
    }
    private void updateData(User entitiy, User user){
        entitiy.setName(user.getName());
        entitiy.setEmail(user.getEmail());
        entitiy.setPhone(user.getPhone());
    }

}
