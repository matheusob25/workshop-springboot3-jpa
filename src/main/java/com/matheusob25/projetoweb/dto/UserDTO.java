package com.matheusob25.projetoweb.dto;

import com.matheusob25.projetoweb.entities.User;

public class UserDTO {
    private String email;
    private String password;

    public UserDTO(User user) {
        email = user.getEmail();
        password = user.getPassword();
    }
    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
