package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad que representa la confiteria del cine
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Type(type="text")
    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private Double valor;

    @Type(type="text")
    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double calificacion;

    @Column(nullable = false)
    private Integer calificadores;

    @ToString.Exclude
    @OneToMany(mappedBy = "confiteria")
    private List<DetalleVentaConfiteria> detalleVentaConfiteria;

    @Builder
    public Confiteria(String nombre, String imagen, Double valor, String descripcion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.valor = valor;
        this.descripcion = descripcion;
    }
}
