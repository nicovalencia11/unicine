package co.edu.uniquindio.unicine.entidades;

import co.edu.uniquindio.unicine.enums.Estado;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Entidad que representa los cupones de descuentos
 */
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String criterio;

    @Column(nullable = false)
    private Estado estado;

    @ManyToMany
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "cupon")
    private List<Venta> ventas;

    @Builder
    public Cupon(Double descuento, LocalDate fechaVencimiento, String descripcion, String criterio, Estado estado, List<Cliente> clientes) {
        this.descuento = descuento;
        this.fechaVencimiento = fechaVencimiento;
        this.descripcion = descripcion;
        this.criterio = criterio;
        this.estado = estado;
        this.clientes = clientes;
    }
}
