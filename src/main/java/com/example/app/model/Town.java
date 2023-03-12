package com.example.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String town;
    private float lat;
    private float lon;
    private float temp;
    private float feellike;
    private float preasure;
    private float windspeed;

    public Town(){}

    public Town(long id, String town, float lat, float lon, float temp, float feellike, float preasure, float windspeed) {
        this.id = id;
        this.town = town;
        this.lat = lat;
        this.lon = lon;
        this.temp = temp;
        this.feellike = feellike;
        this.preasure = preasure;
        this.windspeed = windspeed;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Town{");
        sb.append("id=").append(id);
        sb.append(", town='").append(town).append('\'');
        sb.append(", lat='").append(lat).append('\'');
        sb.append(", lon='").append(lon).append('\'');
        sb.append(", temp='").append(temp).append('\'');
        sb.append(", feellike='").append(feellike).append('\'');
        sb.append(", preasure='").append(preasure).append('\'');
        sb.append(", windspeed=").append(windspeed);
        sb.append('}');
        return sb.toString();
    }
}