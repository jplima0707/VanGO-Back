package com.example.VanGO_Back.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enterprise_id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 20, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "enterprise")
    private List<Driver> drivers;

    public Enterprise() {
    }

    public Enterprise(String name, String cnpj, String email, String phone, List<Driver> drivers) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.phone = phone;
        this.drivers = drivers;
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
        if (cnpj == null || cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ must be 14 characters long.");
        }
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void updateCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
        driver.setEnterprise(this);
    }
}