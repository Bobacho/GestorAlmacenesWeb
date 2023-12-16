package com.example.gestoralmacenes.models.personas;

import com.example.gestoralmacenes.models.documentos.Documento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor

@Table(name = "Emisor")
public class Emisor {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "IdEmpleado")
    private Long IdEmpleado;
    @Column(name = "IdProveedor")
    private Long IdProveedor;
    @OneToOne(targetEntity = Cliente.class , cascade = CascadeType.ALL)
    private Cliente client;
    @OneToOne(targetEntity = Empleado.class , cascade = CascadeType.ALL)
    private Empleado empleado;
    @OneToOne(targetEntity = Proveedor.class, cascade = CascadeType.ALL)
    private Proveedor proveedor;
    @Column(name = "TipoEmisor")
    private String TipoEmisor;
    @OneToMany(targetEntity = Documento.class,fetch = FetchType.LAZY)
    private List<Documento> Documentos;
}
