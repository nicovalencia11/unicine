package co.edu.uniquindio.unicine.entidades;

import co.edu.uniquindio.unicine.enums.Estado;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa los clientes del sistema
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 10)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Type(type="text")
    private String imgPerfil;

    @Column(nullable = false)
    private Estado estado;

    @OneToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefono;

    @ManyToMany(mappedBy = "clientes")
    private List<Cupon> cupones;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

    @Builder
    public Cliente(String cedula, String nombre, String correo, String imgPerfil, Estado estado, Usuario usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.imgPerfil = imgPerfil;
        this.estado = estado;
        this.usuario = usuario;
    }
}
