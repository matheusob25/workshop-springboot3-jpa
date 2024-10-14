package com.matheusob25.projetoweb.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Esses @ são anotações que o JPA utiliza para o mapeamento


@Entity // @Entity basicamente mapea essa classe como uma tabela no banco de dados, quando a aplicação iniciar deve ter uma tabela referenciando essa classe.
@Table(name = "tb_user")  // @Table só serve para que eu escolha o nome da tabela, caso não exista essa anotação, a tabela vem com um nome padrão
public class User implements Serializable{
    @Id // Define que o atributo id do tipo Long será uma chave primária no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // como o próprio nome ja mostra, o id será incrementado automaticamente, igual ao auto increment do MySQL
    private Long id;

    // Os demais atributos se tornam campos normais na tabela
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore // Essa anotação é mais simples de ser explicada na prática, mas basicamente grande parte dos frameworks back-end retornam dados em Json,
    // o JsonIgnore vai impedir que os dados de pedido atrelados a usuário(user) sejam retornados na requisição de usuários

    @OneToMany(mappedBy = "client") // Essa anotação define o relacionamento entre usuários(users) e pedidos(orders) no caso um para muitos,o relacionamento deve ser
    // definido nas duas classes, na classe orders essa anptação é um ManyToOne(muitos para um), isso já garante que cada pedido tenha a chave estrangeira de
    // usuário acoplada na tabela de pedidos
    private List<Order> orders = new ArrayList<>();

    public User() {

    }
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
