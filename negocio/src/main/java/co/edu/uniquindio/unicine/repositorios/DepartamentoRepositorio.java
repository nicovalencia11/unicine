package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad departamento
 */
@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
}
