package com.example.gestoralmacenes.models.personas;

import com.example.gestoralmacenes.models.documentos.Documento;
import jakarta.persistence.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Receptor")
public class Receptor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "IdEmpleado")
    private Long IdEmpleado;
    @Column(name = "IdProveedor")
    private Long IdProveedor;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Cliente.class)
    private Cliente client;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Empleado.class)
    private Empleado empleado;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Proveedor.class)
    private Proveedor proveedor;
    @Column(name = "TipoReceptor")
    private String TipoReceptor;
    @OneToMany(targetEntity = Documento.class,fetch = FetchType.LAZY)
    private List<Documento> Documentos;
}
