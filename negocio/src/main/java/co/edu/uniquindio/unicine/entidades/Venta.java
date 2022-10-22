package co.edu.uniquindio.unicine.entidades;

import co.edu.uniquindio.unicine.enums.MedioPago;
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

    @Column(nullable = false)
    private double valorTotal;

    @Column(nullable = false)
    private MedioPago medioPago;

    @ToString.Exclude
    @OneToMany(mappedBy = "venta")
    private List<Entrada> entradas;

    @ToString.Exclude
    @OneToMany(mappedBy = "venta")
    private List<DetalleVentaConfiteria> detalleVentaConfiteria;

    @ManyToOne
    @ToString.Exclude
    private Cupon cupon;

    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;

    @ManyToOne
    @ToString.Exclude
    private HorarioFuncion horarioFuncion;

    @Builder
    public Venta(LocalDateTime fecha, double valorTotal, MedioPago medioPago, Cupon cupon, Cliente cliente, HorarioFuncion horarioFuncion) {
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.medioPago = medioPago;
        this.cupon = cupon;
        this.cliente = cliente;
        this.horarioFuncion = horarioFuncion;
    }
}
