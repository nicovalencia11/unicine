package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad que representa los horarios de una funcion
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HorarioFuncion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false)
    @Type(type = "text")
    private String distribucionVentas;

    @ManyToOne
    @ToString.Exclude
    private Funcion funcion;

    @ToString.Exclude
    @OneToMany(mappedBy = "horarioFuncion")
    private List<Venta> ventas;

    @Builder
    public HorarioFuncion(LocalDateTime fechaHora, String distribucionVentas) {
        this.fechaHora = fechaHora;
        this.distribucionVentas = distribucionVentas;
    }
}
