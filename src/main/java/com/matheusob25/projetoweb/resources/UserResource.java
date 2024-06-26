package com.matheusob25.projetoweb.resources;

import com.matheusob25.projetoweb.dto.UserDTO;
import com.matheusob25.projetoweb.entities.User;
import com.matheusob25.projetoweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.logging.LogManager;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        User user = userService.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }


    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO){
        User user = userService.findByEmail(userDTO.getEmail());
        if(user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword()) ){
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
