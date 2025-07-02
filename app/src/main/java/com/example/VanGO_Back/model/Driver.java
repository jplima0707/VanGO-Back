package com.example.VanGO_Back.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Driver {
    
    @Id
    private Long driver_id; // driver_id is the same as user_id in User

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "driver_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_enterprise_id", nullable = true)
    private Enterprise enterprise;

   @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Station> stations;

    @Column(length = 255, nullable = true)
    private String license_number;

    @ManyToMany
    @JoinTable(
        name = "drive",
        joinColumns = @JoinColumn(name = "driver_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private List<Vehicle> vehicles; 

    public Driver() {
    }

    public Driver(User user, Enterprise enterprise, String license_number) {
        this.user = user;
        this.enterprise = enterprise;
        this.license_number = license_number;
        this.driver_id = user.getUser_id(); // driver_id is the same as user_id in User
        this.vehicles = new ArrayList<>();
        this.stations = new ArrayList<>();
    }

    public Long getdriver_id() {
        return driver_id;
    }

    public User getUser() {
        return user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setUser(User user) {
        this.user = user;
        this.driver_id = user.getUser_id(); // Update driver_id when user changes
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        vehicle.getDrivers().add(this); // Ensure bidirectional relationship
    }

    public void addStation(Station station) {
        this.stations.add(station);
        station.setDriver(this); 
    }
}
