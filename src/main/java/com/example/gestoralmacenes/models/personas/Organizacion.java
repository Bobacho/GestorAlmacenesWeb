package com.example.gestoralmacenes.models.personas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Organizacion")
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Ruuc")
    private String Ruuc;
    @Column(name = "TipoOrganizacion")
    @Enumerated(value = EnumType.STRING)
    private TipoOrganizaciones TipoOrganizacion;
    @Column(name = "Tamaño")
    private Integer Tamaño;
    @Column(name = "Sector")
    @Enumerated(value = EnumType.STRING)
    private Sectores Sector;
}
