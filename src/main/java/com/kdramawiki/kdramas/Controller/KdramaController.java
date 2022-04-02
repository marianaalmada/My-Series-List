package com.kdramawiki.kdramas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.kdramawiki.kdramas.Entity.Kdrama;
import com.kdramawiki.kdramas.Service.KdramaService;

// Controller el la API layer

@RestController
@RequestMapping(value = "/kdrama")
public class KdramaController {
    private final KdramaService kdramaService; 
    
    @Autowired //Indica que todo lo que se encuentre en el constructor instanciado y inyectado dentro del constructor
    public KdramaController(KdramaService kdramaService) {
        this.kdramaService = kdramaService;
    }

    @GetMapping
    public List<Kdrama> getKdrama() {
        return kdramaService.getKdrama(); 
    }

    @PostMapping
    public ResponseEntity<?> addKdrama(@RequestBody Kdrama kdrama) {
        return new ResponseEntity<>(kdramaService.addKdrama(kdrama), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{kdramaId}")
    public void deleteDrama(@PathVariable("kdramaId") Long id) {
        kdramaService.deleteDrama(id);
    }
    
    @PutMapping(path = "/{kdramaId}")
    public Kdrama updateDrama(@PathVariable("kdramaId") Long dramaId, @RequestBody Kdrama drama) {
        return kdramaService.updateDrama(dramaId, drama);
    } 
}
