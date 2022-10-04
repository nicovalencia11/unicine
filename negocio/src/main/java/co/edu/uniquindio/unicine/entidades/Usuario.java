package co.edu.uniquindio.unicine.entidades;

import co.edu.uniquindio.unicine.enums.Rol;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa un usuario del sistema
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 45)
    private String nombreUsuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Rol rol;

    @OneToOne(mappedBy = "usuario")
    private Empleado empleado;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    @Builder
    public Usuario(String nombreUsuario, String password, Rol rol, Empleado empleado, Cliente cliente) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
        this.empleado = empleado;
        this.cliente = cliente;
    }
}
