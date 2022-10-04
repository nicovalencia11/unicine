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
    private Sala sala;

    @ManyToOne
    private Pelicula pelicula;

    @OneToMany(mappedBy = "funcion")
    private List<HorarioFuncion> horario;

    @Builder
    public Funcion(Double valor) {
        this.valor = valor;
    }

}
