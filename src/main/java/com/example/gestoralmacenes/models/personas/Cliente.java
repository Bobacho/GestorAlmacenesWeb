package com.example.gestoralmacenes.models.personas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Cliente")
@Getter
@Setter
@AllArgsConstructor
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Apellido")
    private String Apellido;
    @Column(name = "DNI")
    private String DNI;
    @Column(name = "Correo")
    private String Correo;
    @Column(name = "IdOrganizacion")
    private Long IdOrganizacion;
    @ManyToOne(cascade = CascadeType.ALL)
    private Organizacion organizacion;
}