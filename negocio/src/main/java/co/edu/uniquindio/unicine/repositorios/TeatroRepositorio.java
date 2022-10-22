package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad teatro
 */
@Repository
public interface TeatroRepositorio extends JpaRepository<Teatro,Integer> {

    /**
     * Metodo que obtiene la lista de teatros dado el nombre de ciudad
     * @param nombreCiudad
     * @return
     */
    @Query("select t from Teatro t where t.ciudad.nombre = :nombreCiudad")
    List<Teatro> listar(String nombreCiudad);

    /**
     * Metodo que retorna la lista de teatros dado el id de una ciudad
     * @param codigoCiudad
     * @return
     */
    @Query("select t from Teatro t where t.ciudad.codigo = :codigoCiudad")
    List<Teatro> listarTeatrosByCiudad(Integer codigoCiudad);

}
