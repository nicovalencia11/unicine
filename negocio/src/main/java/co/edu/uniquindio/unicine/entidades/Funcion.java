package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa las funciones de una pelicula
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne
    @ToString.Exclude
    private Sala sala;

    @ManyToOne
    @ToString.Exclude
    private Pelicula pelicula;

    @ToString.Exclude
    @OneToMany(mappedBy = "funcion")
    private List<HorarioFuncion> horario;

    @Builder
    public Funcion(Double valor) {
        this.valor = valor;
    }

}
