package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad pelicula
 */
@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
}
