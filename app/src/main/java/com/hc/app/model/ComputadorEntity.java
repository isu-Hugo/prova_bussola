package com.hc.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbl_computador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComputadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cor;
    private Integer dataFabricacao;

    @OneToMany(mappedBy = "computador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PerifericoEntity> perifericos;

    public PerifericoEntity addPeriferic(PerifericoEntity periferico){
        periferico.setComputador(this);
        this.perifericos.add(periferico);
        return periferico;
    }

    public void removePerierico(PerifericoEntity periferico){
        this.perifericos.remove(periferico);
        periferico.setComputador(null);
    }
}
