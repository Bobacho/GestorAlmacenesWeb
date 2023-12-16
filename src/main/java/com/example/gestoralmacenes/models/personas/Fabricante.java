package com.example.gestoralmacenes.models.personas;

import com.example.gestoralmacenes.models.almacen.Producto;
import jakarta.persistence.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Fabricante")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Ubicacion")
    private String Ubicacion;
    @Column(name = "Contacto")
    private String Contacto;
    @OneToMany(targetEntity = Producto.class,fetch = FetchType.LAZY)
    private List<Producto> productos;
}
