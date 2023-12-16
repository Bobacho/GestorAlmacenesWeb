package com.example.gestoralmacenes.models.transaccion;

import com.example.gestoralmacenes.models.almacen.Almacen;
import com.example.gestoralmacenes.models.personas.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "TransaccionINTCAB")
@Getter
@Setter
@AllArgsConstructor
public class TransaccionInterna{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    protected Long Id;
    @Column(name = "FechaInicio")
    protected LocalDate FechaInicio;
    @Column(name = "FechaFin")
    protected LocalDate FechaFin;
    @OneToMany(targetEntity = TransaccionInternaUnitaria.class,fetch = FetchType.LAZY)
    private List<TransaccionInternaUnitaria> transacciones;
    @OneToOne(targetEntity = com.example.gestoralmacenes.models.almacen.Almacen.class, cascade = CascadeType.ALL)
    private Almacen Almacen;
    @OneToOne(targetEntity = Empleado.class, cascade = CascadeType.ALL)
    private Empleado Encargado;

}
