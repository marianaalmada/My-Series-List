package com.kdramawiki.kdramas.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table
public class Kdrama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    private String description;
    private String genre;
    private float rating;
    private String country;
    private String language;

    public Kdrama(Long id, String name, LocalDate date, 
                String description, String genre, float rating, String country, 
                String language) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.country = country;
        this.language = language;
    }

    public Kdrama() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Kdrama [country=" + country + ", date=" + date + ", description=" + description + ", genre=" + genre
                + ", id=" + id + ", language=" + language + ", name=" + name + ", rating=" + rating + "]";
    }
}



/* id, nombre, fecha de estreno, descrición, género, rating, país, idioma*/