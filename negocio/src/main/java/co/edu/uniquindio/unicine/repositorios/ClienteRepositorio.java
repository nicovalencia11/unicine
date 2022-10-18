package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad cliente
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    @Query("select c from Cliente c where c.correo=:email")
    Cliente obtener(String email);

    Cliente findByCorreo(String email);

    Cliente findByCorreoAndCedula(String email, String cedula);

    @Query("select c.cupones from Cliente c where c.correo = :correo")
    List<Cupon> listarCuponesCliente(String correo);


    @Query("select cli.nombre, vent from Cliente cli left join cli.ventas vent")
    List<Object[]> obtenerComprasTodos();

}
