package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa las entradas elegidas para la funcion
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrada implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Integer fila;

    @Column(nullable = false)
    private Integer silla;

    @ManyToOne
    private Venta venta;

    @Builder
    public Entrada(Integer fila, Integer silla) {
        this.fila = fila;
        this.silla = silla;
    }
}
