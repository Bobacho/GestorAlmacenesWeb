package com.example.gestoralmacenes.models.documentos;

import com.example.gestoralmacenes.models.personas.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "RegistroContableCAB")
@Getter
@Setter
@AllArgsConstructor
public class RegistrosContables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "NroOrden")
    private String NroOrden;
    @Column(name = "Año")
    private Long Año;
    @OneToMany(targetEntity = RegistroContableDET.class,fetch = FetchType.LAZY)
    private List<RegistroContableDET> detalles;
    @Entity
    @Table(name = "RegistroContableDET")
    @Getter
    @Setter
    @AllArgsConstructor
    public class RegistroContableDET{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long Id;
        @Column(name="IdRegistroContableCAB")
        private Long IdRegistroContableCAB;
        @ManyToOne(cascade = CascadeType.ALL)
        private RegistrosContables registrosContables;
        @Column(name = "Descripcion")
        private String Descripcion;
        @Column(name = "FechaContable")
        private LocalDate FechaContable;
        @Column(name = "Cuenta")
        private Float Cuenta;
        @Column(name = "TipoCuenta")
        private TipoCuenta tipo;
    }
}
