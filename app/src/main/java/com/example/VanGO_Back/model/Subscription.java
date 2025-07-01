package com.example.VanGO_Back.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Subscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscription_id;

    @OneToOne
    @JoinColumn(name = "fk_client_id", nullable = false)
    private Long user_id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Column(nullable = false)
    private boolean isActive;

    public Subscription() {
    }

    public Subscription(Long user_id, LocalDateTime startDate, LocalDateTime endDate) {
        this.user_id = user_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = false;
    }

    public Long getsubscription_id() {
        return subscription_id;
    }

    public Long getuser_id() {
        return user_id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setuser_id(Long user_id) {
        this.user_id = user_id; 
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
