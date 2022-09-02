package com.revature.eCommerce.dtos;

public class Principal {
    private String email;
    private String password;

    public Principal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Principal() {
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
