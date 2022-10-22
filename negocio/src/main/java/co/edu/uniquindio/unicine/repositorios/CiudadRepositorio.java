package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad ciudad
 */
@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad, Integer> {

}
