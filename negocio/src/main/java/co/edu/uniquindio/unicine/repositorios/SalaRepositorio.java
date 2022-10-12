package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad sala
 */
@Repository
public interface SalaRepositorio extends JpaRepository<Sala, Integer> {
}
