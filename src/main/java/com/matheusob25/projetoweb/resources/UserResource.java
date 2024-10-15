package com.matheusob25.projetoweb.resources;

import com.matheusob25.projetoweb.dto.UserDTO;
import com.matheusob25.projetoweb.entities.User;
import com.matheusob25.projetoweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.logging.LogManager;

@RestController // anotação para definir que essa classe é um rest controller
@CrossOrigin("*")  //Cross origin permite que aplicações rodando em domínios ou portas diferentes possam acessar a API
@RequestMapping(value = "/users") // definindo que a rota padrão para acessar os dados de users será localhost:8080/users
public class UserResource {

    @Autowired // essa anotação facilita para que eu não precise fazer um construtor para injetar um objeto do tipo UserService dentro da variável de forma manual
    private UserService userService;

    @GetMapping // requisição definida como get
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();          //coleta os dados que o service buscou do repository e retorna a resposta com o status
        return ResponseEntity.ok().body(users);            // status .ok() será o 200 e o body retorna as informações do user em json
    }

    @GetMapping(value = "/{id}") // nesse caso dentro da url será necessário passar o parâmetro do user específico que a gente procura
    public ResponseEntity<User> findById(@PathVariable Long id){      // @PathVariable faz com que a variável dentro da url seja colocada como parâmetro para a função
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        User user = userService.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping   //requisição post
    public ResponseEntity<User> save(@RequestBody User user){         // request body para que o metodo reconheça como parâmetro um json com os dados de user
        user = userService.insert(user);                    //
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                                              path("/{id}").
                                              buildAndExpand(user.getId()).
                                              toUri(); // configurando URI que será retornada ao criar user
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
        User user = userService.login(userDTO);
        return ResponseEntity.ok().body(user);

    }

}
