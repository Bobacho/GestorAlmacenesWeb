package com.example.gestoralmacenes.models.personas;

import com.example.gestoralmacenes.models.almacen.Almacen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Rango")
    private String Rango;
    @Column(name = "DescripcionResponsabilidad")
    private String DescripcionResponsabilidad;
    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    private Usuario usuario;
    @Column(name = "DNI")
    private String DNI;
    @Column(name = "NivelEstudio")
    private String NivelEstudio;
    @Column(name = "Telefono")
    private String Telefono;
    @Column(name = "Correo")
    private String Correo;
    @Column(name = "IdAlmacen")
    private Long IdAlmacen;
    @ManyToOne
    private Almacen almacen;
}
