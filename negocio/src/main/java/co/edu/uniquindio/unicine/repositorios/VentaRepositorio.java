package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad venta
 */
@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Integer> {

    @Query("select v from Venta v where v.cliente.correo = :correo")
    List<Venta> ventasPorEmailUsuario(String correo);


    @Query("select e from Venta v join v.entradas e where v.codigo = :idCompra")
    List<Entrada> entradasPorCompra(Integer idCompra);

}
