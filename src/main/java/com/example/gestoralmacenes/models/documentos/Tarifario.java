package com.example.gestoralmacenes.models.documentos;

import com.example.gestoralmacenes.models.almacen.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Tarifario")
public class Tarifario {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "PrecioUnitario")
    private Float PrecioUnitario;
    @Column(name = "Cantidad")
    private Integer Cantidad;
    @Column(name = "Impuestos")
    private Float Impuestos;
    @Column(name = "Descuento")
    private Float Descuento;
    @Column(name = "FechaVencimiento")
    private LocalDate FechaVencimiento;
    @Column(name = "IdProducto")
    private Long IdProducto;
    @ManyToOne
    private Producto producto;
}
