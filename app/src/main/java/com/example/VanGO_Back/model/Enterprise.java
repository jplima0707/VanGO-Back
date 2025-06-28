package com.example.VanGO_Back.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enterprise_id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = true)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Enterprise() {
    }

    public Enterprise(String name, String cnpj, String email, String phone) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
    }

    public Long getEnterprise_id() {
        return enterprise_id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}