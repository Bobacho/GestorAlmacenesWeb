package com.example.gestoralmacenes.models.almacen;

import com.example.gestoralmacenes.models.personas.Empleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.aspectj.lang.annotation.Around;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@Table(name = "Estanteria")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Estanteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "NroLote")
    private String NroLote;
    @Column(name = "IdAlmacen")
    private Long IdAlmacen;
    @Column(name = "Categoria")
    @Enumerated(value = EnumType.STRING)
    private Categorias Categoria;
    @OneToMany(targetEntity = BloqueEstanteria.class,fetch = FetchType.LAZY)
    private List<BloqueEstanteria> estanterias;
}
