package com.parcial.web.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "programa_academico")
public class ProgramaAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nivel;
    private Integer duracionSemestres;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;
}