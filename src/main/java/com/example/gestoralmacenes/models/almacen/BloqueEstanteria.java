package com.example.gestoralmacenes.models.almacen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "BloqueEstanteria")
public class BloqueEstanteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "Largo")
    private Float Largo;
    @Column(name = "Altura")
    private Float Altura;
    @Column(name = "Profundidad")
    private Float Profundidad;
    @Column(name = "PesoMaximo")
    private Float PesoMaximo;
    @Column(name = "PesoActual")
    private Float PesoActual;
    @Column(name = "IdEstanteria")
    private Long IdEstanteria;
    @ManyToOne(cascade = CascadeType.ALL)
    private Estanteria estanteria;

}
