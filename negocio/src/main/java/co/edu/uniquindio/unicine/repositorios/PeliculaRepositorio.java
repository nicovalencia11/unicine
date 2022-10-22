package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad pelicula
 */
@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {



}
