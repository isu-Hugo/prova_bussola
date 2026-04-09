package com.hc.app.controller;

import com.hc.app.model.PerifericoEntity;
import com.hc.app.service.ComputadorService;
import com.hc.app.service.PerifericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/periferico")
@CrossOrigin("*")
public class PerifericoController {
    @Autowired
    private PerifericoService perifericoService;
    @Autowired
    private ComputadorService computadorService;

    @PostMapping("/{id}")
    public ResponseEntity<?> createPeriferico(@PathVariable("id") Long id, @RequestBody PerifericoEntity periferico){
        var response = this.computadorService.addPeriferico(id, periferico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idComp}/{idPeri}")
    public ResponseEntity<?> deletePeriferico(@PathVariable("idComp") Long idComp, @PathVariable("idPeri") Long idPeri){
//        Aqui eu tambem poderia excluir apenas pelo id do periferico
        var periferico = this.perifericoService.findById(idPeri);
        var response = this.computadorService.removePerierico(idComp, periferico);
        return ResponseEntity.ok(periferico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePeriferico(@PathVariable("id") Long id , @RequestBody PerifericoEntity periferico){
        var response = this.perifericoService.updatePeriferico(id, periferico);
        return ResponseEntity.ok(response);
    }


}
