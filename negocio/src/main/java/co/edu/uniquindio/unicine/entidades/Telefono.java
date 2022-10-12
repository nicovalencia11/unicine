package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa los telefonos de los clientes
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Telefono implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 10)
    private String telefono;

    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;

    @Builder
    public Telefono(String telefono) {
        this.telefono = telefono;
    }
}
