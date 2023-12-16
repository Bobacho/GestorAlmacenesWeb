package com.example.gestoralmacenes.models.documentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "LicenciaDeFuncionamiento")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class LicenciaDeFuncionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NumeroLicencia;
    @Column(name = "Municipalidad")
    private String Municipalidad;
    @Column(name = "FechaEmision")
    private LocalDate FechaEmision;
}