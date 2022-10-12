package co.edu.uniquindio.unicine.dtos;

import co.edu.uniquindio.unicine.enums.Estado;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FuncionDTO implements Serializable {

    private String nombrePelicula;
    private Estado estado;
    private String teatro;
    private String ciudad;

}
