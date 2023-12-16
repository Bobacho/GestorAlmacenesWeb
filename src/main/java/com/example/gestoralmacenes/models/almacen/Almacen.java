package com.example.gestoralmacenes.models.almacen;

import com.example.gestoralmacenes.models.documentos.LicenciaDeFuncionamiento;
import com.example.gestoralmacenes.models.personas.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Almacen")
public class Almacen {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "NumeroEstanteria")
    private Integer NumeroEstanteria;
    @Column(name="Ubicacion")
    private String Ubicacion;
    @Column(name = "nroLicencia")
    private Long nroLicencia;
    @OneToOne(targetEntity = LicenciaDeFuncionamiento.class,cascade = CascadeType.ALL)
    private LicenciaDeFuncionamiento licenciaDeFuncionamiento;
    @OneToMany(targetEntity = Empleado.class,fetch = FetchType.LAZY)
    private List<Empleado> empleados;
}
