package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad telefono
 */
@Repository
public interface TelefonoRepositorio extends JpaRepository<Telefono, Integer> {
}
