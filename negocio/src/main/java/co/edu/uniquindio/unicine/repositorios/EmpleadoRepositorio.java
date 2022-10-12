package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad empleado
 */
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
