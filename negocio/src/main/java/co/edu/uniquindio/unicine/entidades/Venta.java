package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa una venta
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venta implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "venta")
    private List<Entrada> entradas;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVentaConfiteria> detalleVentaConfiteria;

    @ManyToOne
    private Cupon cupon;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private HorarioFuncion horarioFuncion;

    @Builder
    public Venta(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
