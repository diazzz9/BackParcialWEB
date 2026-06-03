package com.parcial.web.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "facultad")
public class Facultad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String decano;
    private String ubicacion;
}