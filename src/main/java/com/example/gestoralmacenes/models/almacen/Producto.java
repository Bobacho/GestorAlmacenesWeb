package com.example.gestoralmacenes.models.almacen;

import com.example.gestoralmacenes.models.documentos.Tarifario;

import java.util.Enumeration;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Producto")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name ="Descripcion")
    private String Descripcion;
    @Column(name = "Garantia")
    private Boolean Garantia;
    @Column(name = "IdAlmacen")
    private Long IdAlmacen;
    @Column(name = "IdFabricante")
    private Long IdFabricante;
    @Column(name = "IdContenedor")
    private Long IdContenedor;
    @Column(name= "Unidad_Medida")
    @Enumerated(value = EnumType.STRING)
    private Unidad Unidad_medidad;
}
