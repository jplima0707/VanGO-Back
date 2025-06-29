package com.example.VanGO_Back.model;

import java.util.List;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId; 

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToMany(mappedBy = "vehicles")
    private List<Driver> drivers;

    @Column(length = 255)
    private String model;

    @Column(length = 20, nullable = false, unique = true)
    private String licensePlate;

    @Column(length = 20)
    private String color;

    @Column(length = 4, nullable = false)
    private int year;

    @Column(length = 3, nullable = false)
    private int capacity;

    private float fuelConsumption; 

    public Vehicle() {
    }

    public Vehicle(Enterprise enterprise, List<Driver> drivers, String model, String licensePlate, String color, int year, int capacity, float fuelConsumption) {
        this.enterprise = enterprise;
        this.drivers = drivers;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
        this.year = year;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        if (year < 1900 || year > LocalDate.now().getYear() + 1) {
            throw new IllegalArgumentException("Year must be between 1886 and next year.");
        }
        this.year = year;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer.");
        }
        this.capacity = capacity;
    }

    public void setFuelConsumption(float fuelConsumption) {
        if (fuelConsumption <= 0) {
            throw new IllegalArgumentException("Fuel consumption must be a positive number.");
        }
        this.fuelConsumption = fuelConsumption;
    }
}
