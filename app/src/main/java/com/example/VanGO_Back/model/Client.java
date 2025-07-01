package com.example.VanGO_Back.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Client {
    
    @Id
    private Long client_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "client_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "fk_subscription_id", nullable = false)
    private Subscription subscription;

    @OneToMany(mappedBy = "client")
    List<Acess> accessList;



    public Client() {
    }

    public Client(User user, Subscription subscription) {
        this.user = user;
        this.subscription = subscription;
        this.client_id = user.getUser_id(); // client_id is the same as user_id in User
    }

    public Long getClient_id() {
        return client_id;
    }

    public User getUser() {
        return user;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setUser(User user) {
        this.user = user;
        this.client_id = user.getUser_id(); // Update client_id if user changes
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

}
