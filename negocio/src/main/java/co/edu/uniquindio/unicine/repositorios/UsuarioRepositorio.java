package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para la entidad usuario
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    /**
     * Login por medio del nombre de usuario y contraseña
     * @param usuario
     * @param pass
     * @return
     */
    Usuario findByNombreUsuarioAndPassword(String usuario, String pass);

    /**
     * Login con correo electronico y contraseña
     * @param correo
     * @param password
     * @return
     */
    @Query("select u from Usuario u where u.cliente.correo = :correo and u.password = :password")
    Usuario login(String correo, String password);

    /**
     * Metodo que permite obtener el usuario dado un correo o
     * el nombre de usuario
     * @param correo
     * @return
     */
    @Query("select u from Usuario u where u.cliente.correo =:correo or u.nombreUsuario =:nombreUsuario")
    Optional<Usuario> verificarCorreoNombreUsuario(String correo, String nombreUsuario);
}
