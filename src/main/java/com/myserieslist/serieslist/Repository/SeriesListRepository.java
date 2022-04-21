package com.myserieslist.serieslist.Repository;

import com.myserieslist.serieslist.Entity.SeriesList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesListRepository extends JpaRepository<SeriesList, Long> {
    
    SeriesList findByName(String name);
}
