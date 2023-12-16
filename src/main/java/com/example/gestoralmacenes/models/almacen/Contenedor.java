package com.example.gestoralmacenes.models.almacen;

import com.example.gestoralmacenes.models.personas.Empleado;
import com.example.gestoralmacenes.models.transaccion.TransaccionExternaUnitaria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Contenedor")
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Contenedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "CapacidadMaxima")
    private Long CapacidadMaxima;
    @Column(name = "CapacidadActual")
    private Long CapacidadActual;
    @Column(name = "Largo")
    private Float Largo;
    @Column(name = "Altura")
    private Float Altura;
    @Column(name = "Profundidad")
    private Float Profundidad;
    @Column(name = "Peso")
    private Float Peso;
    @OneToMany(targetEntity = Producto.class,fetch = FetchType.LAZY)
    private List<Producto> productos;
    @ManyToMany
    private List<TransaccionExternaUnitaria> transaccionesExternas;
}
