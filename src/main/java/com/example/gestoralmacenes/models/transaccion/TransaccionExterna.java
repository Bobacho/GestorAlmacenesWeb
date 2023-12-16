package com.example.gestoralmacenes.models.transaccion;

import com.example.gestoralmacenes.models.documentos.Documento;
import com.example.gestoralmacenes.models.documentos.RegistrosContables;
import com.example.gestoralmacenes.models.personas.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "TransaccionEXTCAB")
@Getter
@Setter
@AllArgsConstructor
public class TransaccionExterna{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    protected Long Id;
    @Column(name = "FechaInicio")
    protected LocalDate FechaInicio;
    @Column(name = "FechaFin")
    protected LocalDate FechaFin;
    @OneToMany(targetEntity = TransaccionExternaUnitaria.class,fetch = FetchType.LAZY)
    private List<TransaccionExternaUnitaria> transacciones;
    @OneToOne(targetEntity = Documento.class,cascade = CascadeType.ALL)
    private Documento documento;
    @OneToOne(targetEntity = RegistrosContables.class, cascade = CascadeType.ALL)
    private RegistrosContables registrosContable;
}
