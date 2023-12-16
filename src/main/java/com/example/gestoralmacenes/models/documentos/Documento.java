package com.example.gestoralmacenes.models.documentos;

import com.example.gestoralmacenes.models.personas.Emisor;
import com.example.gestoralmacenes.models.personas.Receptor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Entity
@Table(name = "Documento")
@Getter
@Setter
@AllArgsConstructor
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "NroOrden")
    private String NroOrden;
    @Column(name = "FechaEmision")
    private LocalDate FechaEmision;
    @Column(name = "FechaVencimiento")
    private LocalDate FechaVencimiento;
    @Column(name = "Ubicacion")
    private String Ubicacion;
    @ManyToOne(cascade = CascadeType.ALL)
    private Receptor receptor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Emisor emison;
    @Column(name= "TotalPaquetes")
    private Long TotalPaquetes;
    @Column(name = "TipoDocumento")
    @Enumerated(value = EnumType.STRING)
    private TipoDocumentos TipoDocumento;
}
