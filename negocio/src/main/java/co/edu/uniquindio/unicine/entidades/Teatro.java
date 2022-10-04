package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa los teatros de cine de una ciudad
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teatro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 10)
    private String telefono;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;

    @Builder
    public Teatro(String nombre, String direccion, String telefono, Ciudad ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }
}
