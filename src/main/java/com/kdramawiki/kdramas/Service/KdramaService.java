package com.kdramawiki.kdramas.Service;

import java.util.List;

// import javax.transaction.Transactional;

import com.kdramawiki.kdramas.Entity.Kdrama;
import com.kdramawiki.kdramas.Repository.KdramaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service es responsable de la lógica de negocio

@Service //indica que es una clase que tiene que ser instanciada. Tambien se puede usar @Componet
public class KdramaService {
    private final KdramaRepository kdramaRepository;
    // private Kdrama kdrama;

    @Autowired
    public KdramaService(KdramaRepository kdramaRepository) {
        this.kdramaRepository = kdramaRepository;
    }

    //Obtener todos los dramas
    public List<Kdrama> getKdrama() {
        return kdramaRepository.findAll();
    }

    //Agregar un nuevo drama
    public Kdrama addKdrama(Kdrama kdrama) {
        return kdramaRepository.save(kdrama);
    }

    //Eliminar un drama
    public void deleteDrama(Long id) {
        kdramaRepository.deleteById(id);
    }

    // Modificar un drama
    public Kdrama updateDrama(Long kdramaId, Kdrama kdrama) {
        Kdrama drama = kdramaRepository.findById(kdramaId).get();
        drama.setName(kdrama.getName());
        return kdramaRepository.save(drama);
    }

    // Buscar drama por nombre
    public Kdrama dramaByName(String name) {
        return kdramaRepository.findKdramaByName(name);
    }
}
