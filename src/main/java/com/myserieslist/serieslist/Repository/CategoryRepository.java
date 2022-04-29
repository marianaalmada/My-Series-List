package com.myserieslist.serieslist.Repository;

import java.util.Optional;

import com.myserieslist.serieslist.Entity.Category;
import com.myserieslist.serieslist.Entity.Serie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    Optional<Category> findByIdAndSeries(Long categoryId, Serie serie);
    
}
