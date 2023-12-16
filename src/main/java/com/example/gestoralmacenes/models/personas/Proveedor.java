package com.example.gestoralmacenes.models.personas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "TelefonoContacto")
    private String TelefonoContacto;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "RUUC")
    private String RUUC;
    @Column(name = "GiroProveedor")
    private String GiroProveedor;
    @Column(name = "TelefonoProveedor")
    private String TelefonoProveedor;
    @Column(name = "Contacto")
    private String Contacto;
}
