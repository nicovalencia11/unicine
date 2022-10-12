package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa los detalles de una venta de confiteria
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleVentaConfiteria implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Integer cantidad;

    @ManyToOne
    @ToString.Exclude
    private Confiteria confiteria;

    @ManyToOne
    @ToString.Exclude
    private Venta venta;

    @Builder
    public DetalleVentaConfiteria(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
