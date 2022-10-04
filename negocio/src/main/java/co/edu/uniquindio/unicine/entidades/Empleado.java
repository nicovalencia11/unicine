package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa un empleado del sistema
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 10)
    private String cedula;

    @Column(nullable = false)
    private String correo;

    @OneToOne
    private Usuario usuario;

    @Builder
    public Empleado(String nombre, String cedula, String correo, Usuario usuario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.usuario = usuario;
    }
}
