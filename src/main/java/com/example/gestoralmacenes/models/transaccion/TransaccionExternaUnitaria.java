package com.example.gestoralmacenes.models.transaccion;

import com.example.gestoralmacenes.models.almacen.Contenedor;
import com.example.gestoralmacenes.models.almacen.Unidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "TransaccionEXTDET")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TransaccionExternaUnitaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "IdTransaccionEXTCAB")
    private Long IdTransaccionEXTCAB;
    @Column(name = "Secuencia")
    private String Secuencia;
    @Column(name = "Cantidad")
    private Integer Cantidad;
    @Column(name = "UnidadMedida")
    @Enumerated(value = EnumType.STRING)
    private Unidad UnidadMedida;
    @Column(name = "Longitud")
    private Float longitud;
    @Column(name = "Profundidad")
    private Float profundidad;
    @Column(name = "Altura")
    private Float altura;
    @ManyToMany
    private List<Contenedor> contenedores;
}
