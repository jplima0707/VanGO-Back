package com.example.VanGO_Back.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;

@Entity
public class Acess {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long access_id;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(length = 255, nullable = false, unique = true)
    private String code;
    private boolean isActive;
    private LocalDateTime expiresAt;

    public Acess() {
    }

    public Acess(Trip trip, Client client, String code, LocalDateTime expiresAt) {
        this.trip = trip;
        this.client = client;
        this.code = code;
        this.isActive = LocalDateTime.now().isBefore(expiresAt);
        this.expiresAt = expiresAt;
    }

    public Long getAccess_id() {
        return access_id;
    }

    public Trip getTrip() {
        return trip;
    }

    public Client getClient() {
        return client;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return LocalDateTime.now().isBefore(this.expiresAt);
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        if (expiresAt.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Expiration time cannot be in the past.");
        }
        this.expiresAt = expiresAt;
        this.isActive = LocalDateTime.now().isBefore(expiresAt);
    }

}
