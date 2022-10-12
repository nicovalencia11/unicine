package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.dtos.FuncionDTO;
import co.edu.uniquindio.unicine.entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad funcion
 */
@Repository
public interface FuncionRepositorio extends JpaRepository<Funcion, Integer> {

    /**
     * Metodo que permite obtener el nombre de la peliducla de una funcion
     * dado el id de la funcion
     * @param codigoFuncion
     * @return
     */
    @Query("select f.pelicula.nombre from Funcion f where f.codigo = :codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);

    @Query("select " +
            "new co.edu.uniquindio.unicine.dtos.FuncionDTO(" +
            "f.pelicula.nombre, " +
            "f.pelicula.estado, " +
            "f.sala.teatro.nombre, " +
            "f.sala.teatro.ciudad.nombre )" +
            "from Funcion f " +
            "where f.pelicula.codigo = :codigoPelicula")
    List<FuncionDTO> listarFunciones(Integer codigoPelicula);

}
