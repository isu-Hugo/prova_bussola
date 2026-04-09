package com.hc.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_erifericos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerifericoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "computador_id")
    private ComputadorEntity computador;
}
