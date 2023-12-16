package com.example.gestoralmacenes.models.transaccion;

import com.example.gestoralmacenes.models.almacen.BloqueEstanteria;
import com.example.gestoralmacenes.models.almacen.Contenedor;
import com.example.gestoralmacenes.models.almacen.Estanteria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TransaccionINTDET")
@Getter
@Setter
@ToString
public class TransaccionInternaUnitaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name="IdTransaccionINTCAB")
    private Long IdTransaccionInternaCAB;
    @OneToOne(targetEntity = Estanteria.class,cascade = CascadeType.ALL)
    private Estanteria Origen;
    @OneToOne(targetEntity = Estanteria.class,cascade = CascadeType.ALL)
    private Estanteria Destino;
    @OneToOne(targetEntity = BloqueEstanteria.class,cascade = CascadeType.ALL)
    private BloqueEstanteria BloqueOrigen;
    @OneToOne(targetEntity = BloqueEstanteria.class,cascade = CascadeType.ALL)
    private BloqueEstanteria BloqueDestino;
    @OneToOne(targetEntity = Contenedor.class,cascade = CascadeType.ALL)
    private Contenedor contenedor;

    public TransaccionInternaUnitaria(Long id, Estanteria origen, Estanteria destino, BloqueEstanteria bloqueOrigen, BloqueEstanteria bloqueDestino, com.example.gestoralmacenes.models.almacen.Contenedor contenedor) {
        Id = id;
        Origen = origen;
        Destino = destino;
        BloqueOrigen = bloqueOrigen;
        BloqueDestino = bloqueDestino;
        this.contenedor = contenedor;
    }

}
