package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa una sala del teatro
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sala implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Type(type = "text")
    private String distribucion;

    @ManyToOne
    @ToString.Exclude
    private Teatro teatro;

    @ToString.Exclude
    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

    @Builder
    public Sala(String descripcion, String distribucion, Teatro teatro) {
        this.descripcion = descripcion;
        this.distribucion = distribucion;
        this.teatro = teatro;
    }
}
