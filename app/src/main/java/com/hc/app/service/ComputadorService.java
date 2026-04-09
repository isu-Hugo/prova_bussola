package com.hc.app.service;

import com.hc.app.model.ComputadorEntity;
import com.hc.app.model.PerifericoEntity;
import com.hc.app.repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadorService {
    @Autowired
    private ComputadorRepository computadorRepository;

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
    public ComputadorEntity update(Long idComputador, ComputadorEntity novocomputador){
        return this.computadorRepository.findById(idComputador)
                .map(computadorEntity -> {
                    computadorEntity.setNome(novocomputador.getNome());
                    computadorEntity.setCor(novocomputador.getCor());
                    computadorEntity.setDataFabricacao(novocomputador.getDataFabricacao());
                    return this.computadorRepository.save(computadorEntity);
                })
                .orElseThrow();
    }

//    DELETE
    public ComputadorEntity deleteComputador(Long idComputador){
        var compuador = this.computadorRepository.findById(idComputador).orElseThrow();
        this.computadorRepository.deleteById(idComputador);
        return compuador;
    }


//    UPDATE
    public ComputadorEntity addPeriferico(Long idComputador, PerifericoEntity periferico){
        var computador = this.computadorRepository.findById(idComputador).orElseThrow();
        computador.addPeriferic(periferico);
        return this.computadorRepository.save(computador);
    }

//    UPDATE
    public ComputadorEntity removePerierico(Long idComputador, PerifericoEntity periferico){
        var computador = this.computadorRepository.findById(idComputador).orElseThrow();
        computador.removePerierico(periferico);
        return this.computadorRepository.save(computador);
    }


}
