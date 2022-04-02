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

    public List<Kdrama> getKdrama() {
        return kdramaRepository.findAll();
    }

    public Kdrama addKdrama(Kdrama kdrama) {
        return kdramaRepository.save(kdrama);
    }

    public void deleteDrama(Long id) {
        kdramaRepository.deleteById(id);
    }

    // @Transactional
    public Kdrama updateDrama(Long kdramaId, Kdrama kdrama) {
        Kdrama drama = kdramaRepository.findById(kdramaId).get();
        drama.setName(kdrama.getName());
        return kdramaRepository.save(drama);
    }
}
