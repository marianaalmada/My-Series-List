package com.kdramawiki.kdramas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdramawiki.kdramas.Entity.Kdrama;

// Repository es responsable del acceso a la base de datos

@Repository
public interface KdramaRepository extends JpaRepository<Kdrama, Long> /*indicar tipo de objeto y el tipo del ID*/ {
    
}
