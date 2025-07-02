package com.example.VanGO_Back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Station {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long station_id;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @Column(length = 255, nullable = false, unique = true)
    private String station_name;

    @Column(length = 255, nullable = true)
    private String passanger_name;

    @Column(length = 255, nullable = false)
    private String street;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 100, nullable = false)
    private String state;

    @Column(length = 20, nullable = false)
    private String cep;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = true)
    private Double latitude;

    @Column(nullable = true)
    private Double longitude;

    public Station() {
    }

    public Station(String street, String city, String state, String cep, Integer number, Double latitude, Double longitude, String station_name, String passanger_name, Driver driver) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station_name = station_name;
        this.passanger_name = passanger_name;
        this.driver = driver;
    }

    public Long getStation_id() {
        return station_id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumber(Integer number) {
        if (number == null || number < 0) {
            throw new IllegalArgumentException("Number must be a non-negative integer.");
        }
        this.number = number;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getPassanger_name() {
        return passanger_name;
    }

    public void setPassanger_name(String passanger_name) {
        this.passanger_name = passanger_name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
