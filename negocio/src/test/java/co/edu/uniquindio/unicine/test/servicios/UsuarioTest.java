package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.enums.Rol;
import co.edu.uniquindio.unicine.servicios.implementacion.UsuarioServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de pruebas unitarias para los servicios de un usuario
 */
@SpringBootTest
@Transactional
public class UsuarioTest {

    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginCorreo() {
        try {
            Usuario usuario = usuarioServicio.loginCorreo("nicolasvalenciamadrid@gmail.com", "nico123");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void loginNombreUsuario() {
        try {
            Usuario usuario = usuarioServicio.loginUsuario("nicovalencia11", "nico123");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuario() {
        Usuario usuario = new Usuario("nicovalencia12","123456", Rol.Cliente);
        Cliente cliente = new Cliente("1094970200","Nicolas Valencia","nicolasvalencnbmbiamadrid@gmail.com","RUTA", Estado.Inactivo, usuario);
        usuario.setCliente(cliente);
        cliente.setUsuario(usuario);
        try {
            Usuario almacenado = usuarioServicio.registrarUsuario(usuario);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuario() {
        Usuario usuario = null;
        try {
            usuario = usuarioServicio.consultarUsuario(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
        try {
            usuario.getCliente().setImgPerfil("nuevaRuta");
            Usuario almacenado = usuarioServicio.actualizarUsuario(usuario);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuario() {
        try {
            usuarioServicio.eliminarUsuario(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        Assertions.assertTrue(true);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarUsuario() {
        try {
            Usuario usuario = usuarioServicio.consultarUsuario(1);
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

}
