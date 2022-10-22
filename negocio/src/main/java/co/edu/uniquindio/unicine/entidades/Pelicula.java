package co.edu.uniquindio.unicine.entidades;

import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.enums.Genero;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa las peliculas
 */
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Type(type="text")
    @Column(nullable = false)
    private String imagen;

    @Type(type="text")
    @Column(nullable = false)
    private String trailer;

    @Type(type="text")
    @Column(nullable = false)
    private String sipnosis;

    @Type(type="text")
    @Column(nullable = false)
    private String reparto;

    @Column(nullable = false)
    private Estado estado;

    @Column(nullable = false)
    private Double calificacion;

    @Column(nullable = false)
    private Integer calificadores;

    @Column(nullable = false)
    @ElementCollection
    private List<Genero> generos;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    @Builder
    public Pelicula(String nombre, String imagen, String trailer, String sipnosis, String reparto, Estado estado, List<Genero> generos) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.trailer = trailer;
        this.sipnosis = sipnosis;
        this.reparto = reparto;
        this.estado = estado;
        this.generos = generos;
    }
}
