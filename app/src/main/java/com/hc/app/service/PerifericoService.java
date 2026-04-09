package com.hc.app.service;

import com.hc.app.model.PerifericoEntity;
import com.hc.app.repository.PerifericoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerifericoService {
    @Autowired
    private PerifericoRepository perifericoRepository;
    @Autowired
    private ComputadorService computadorService;

//    CREATE
    public PerifericoEntity save(Long idComputador, PerifericoEntity periferico){
        this.computadorService.addPeriferico(idComputador, periferico);
        return periferico;
    }

//    READ
    public PerifericoEntity findById(Long idPeriferico){
        return this.perifericoRepository.findById(idPeriferico).orElseThrow();
    }

//    UPDATE
    public PerifericoEntity updatePeriferico(Long idPeriferico, PerifericoEntity newPeriferico){
        return this.perifericoRepository.findById(idPeriferico)
                .map(periferico -> {
                    periferico.setNome(newPeriferico.getNome());
                    return this.perifericoRepository.save(periferico);
                })
                .orElseThrow();
    }

//    DELETE
    public PerifericoEntity deletePeriferico(Long idPeriferico){
        var periferico = this.perifericoRepository.findById(idPeriferico).orElseThrow();
        this.perifericoRepository.deleteById(idPeriferico);
        return periferico;
    }


}
