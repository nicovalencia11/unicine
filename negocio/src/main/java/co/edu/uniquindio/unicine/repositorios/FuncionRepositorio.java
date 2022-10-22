package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.dtos.FuncionDTO;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.enums.Estado;
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

    /**
     * Metodo que permite listar las peliculas de un teatro que esten
     * en cartelera op preventa
     * @param codigoTeatro
     * @param estado
     * @param estado2
     * @return
     */
    @Query("select p from Funcion f join f.pelicula p where f.sala.teatro.codigo = :codigoTeatro and p.estado = :estado or p.estado = :estado2")
    List<Pelicula> listarPeliculasCartelera(Integer codigoTeatro, Estado estado, Estado estado2);

    /**
     * Metodo que permite listar las funciones de una pelicula
     * en un teatro especifico
     * @param codigoPelicula
     * @param codigoTeatro
     * @return
     */
    @Query("select f from Funcion f where f.pelicula.codigo = :codigoPelicula and f.sala.teatro.codigo = :codigoTeatro")
    List<Funcion> listarFuncionesPeliculaTeatro(Integer codigoPelicula, Integer codigoTeatro);

}
