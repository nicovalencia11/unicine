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

    @Column(nullable = false, unique = true, length = 45)
    private String nombreUsuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Rol rol;

    @OneToOne(mappedBy = "usuario")
    @ToString.Exclude
    private Empleado empleado;

    @OneToOne(mappedBy = "usuario")
    @ToString.Exclude
    private Cliente cliente;

    @Builder
    public Usuario(String nombreUsuario, String password, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }
}
