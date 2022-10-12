package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.HorarioFuncion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad del horario de una funcion
 */
@Repository
public interface HorarioFuncionRepositorio extends JpaRepository<HorarioFuncion, Integer> {
}
