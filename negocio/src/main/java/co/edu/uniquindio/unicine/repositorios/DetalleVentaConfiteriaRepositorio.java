package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.DetalleVentaConfiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad detalle venta de confiteria
 */
@Repository
public interface DetalleVentaConfiteriaRepositorio extends JpaRepository<DetalleVentaConfiteria, Integer> {
}
