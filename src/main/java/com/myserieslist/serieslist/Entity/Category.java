package com.myserieslist.serieslist.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Serie> series = new ArrayList<>();

    public Category(Long id, String name, List<Serie> series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", series=" + series + "]";
    }
    
}