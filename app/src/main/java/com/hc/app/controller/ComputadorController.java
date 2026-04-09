package com.hc.app.controller;

import com.hc.app.model.ComputadorEntity;
import com.hc.app.service.ComputadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computador")
@CrossOrigin("*")
public class ComputadorController {
    @Autowired
    private ComputadorService computadorService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ComputadorEntity entity){
        var response = this.computadorService.create(entity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        var response = this.computadorService.findById(id);
        if (response.isPresent())return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();

    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        var response = this.computadorService.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long idComputador, @RequestBody ComputadorEntity computador){
        var response = this.computadorService.update(idComputador, computador);
        if (response.isPresent()) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        var response = this.computadorService.deleteComputador(id);
        if (response.isPresent()) return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }




}
