package com.kdramawiki.kdramas.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity 
@Table(name = "kdrama",
        uniqueConstraints = {
            @UniqueConstraint(name = "kdrama_name_unique", columnNames = "name"),
        }
    )
public class Kdrama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Es buena práctica
    private Long id;

    @Column(nullable = false) 
    private String name;

    private LocalDate date;

    @Column(name = "description",
            columnDefinition = "TEXT") // -> indica el tipo de dato de la columna
    private String description;

    private String genre;
    private float rating;
    private String country;
    private String language;

    @JsonIgnore
    @ManyToMany(mappedBy = "drama")
    private List<DramaList> list = new ArrayList<>();

    public Kdrama(Long id, String name, LocalDate date, String description, String genre, float rating, String country,
            String language, List<DramaList> list) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.country = country;
        this.language = language;
        this.list = list;
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

    public List<DramaList> getList() {
        return list;
    }

    public void setList(List<DramaList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Kdrama [country=" + country + ", date=" + date + ", description=" + description + ", genre=" + genre
                + ", id=" + id + ", language=" + language + ", list=" + list + ", name=" + name + ", rating=" + rating
                + "]";
    }

}
