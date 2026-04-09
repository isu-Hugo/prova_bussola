package com.hc.app.service;

import com.hc.app.model.ComputadorEntity;
import com.hc.app.model.PerifericoEntity;
import com.hc.app.repository.ComputadorRepository;
import com.hc.app.repository.PerifericoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadorService {
    @Autowired
    private ComputadorRepository computadorRepository;
    @Autowired
    private PerifericoRepository perifericoRepository;

//    CREATE
    public ComputadorEntity create(ComputadorEntity computador){
        return this.computadorRepository.save(computador);
    }

//     READ
    public Optional<ComputadorEntity> findById(Long idComputador){
        return this.computadorRepository.findById(idComputador);
    }

//    READ
    public List<ComputadorEntity> findAll(){
        return this.computadorRepository.findAll();
    }

//    UPDATE
    public Optional<ComputadorEntity> update(Long idComputador, ComputadorEntity novocomputador){
        return this.computadorRepository.findById(idComputador)
                .map(computadorEntity -> {
                    computadorEntity.setNome(novocomputador.getNome());
                    computadorEntity.setCor(novocomputador.getCor());
                    computadorEntity.setDataFabricacao(novocomputador.getDataFabricacao());
                    return this.computadorRepository.save(computadorEntity);
                });
    }

//    DELETE
    public Optional<ComputadorEntity> deleteComputador(Long idComputador){
        var computador = this.computadorRepository.findById(idComputador);
        this.computadorRepository.deleteById(idComputador);
        return computador;
    }


//    UPDATE
    public PerifericoEntity addPeriferico(Long idComputador, PerifericoEntity periferico){
        var computador = this.computadorRepository.findById(idComputador).orElseThrow();
        var p = computador.addPeriferic(periferico);
        return this.perifericoRepository.save(p);
//        return this.computadorRepository.save(computador);
    }

//    UPDATE
    public ComputadorEntity removePerierico(Long idComputador, PerifericoEntity periferico){
        var computador = this.computadorRepository.findById(idComputador).orElseThrow();
        computador.removePerierico(periferico);
        return this.computadorRepository.save(computador);
    }


}
