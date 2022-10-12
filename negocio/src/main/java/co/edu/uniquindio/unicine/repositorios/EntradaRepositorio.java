package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad entrada
 */
@Repository
public interface EntradaRepositorio extends JpaRepository<Entrada, Integer> {
}
