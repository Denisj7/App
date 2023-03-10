package com.example.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "weather")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String town;
    private float lat;
    private float lon;
    private float temp;
    private float feellike;
    private float preasure;
    private float windspeed;


    public WeatherEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeellike() {
        return feellike;
    }

    public void setFeellike(float feellike) {
        this.feellike = feellike;
    }

    public float getPreasure() {
        return preasure;
    }

    public void setPreasure(float preasure) {
        this.preasure = preasure;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

}
