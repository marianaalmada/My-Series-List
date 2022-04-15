package com.kdramawiki.kdramas.Repository;

import com.kdramawiki.kdramas.Entity.DramaList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DramaListRepository extends JpaRepository<DramaList, Long> {
    
    DramaList findByName(String name);
}
