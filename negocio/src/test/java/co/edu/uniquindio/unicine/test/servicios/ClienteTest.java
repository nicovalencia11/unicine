package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.enums.Rol;
import co.edu.uniquindio.unicine.servicios.implementacion.ClienteServicioImpl;
import co.edu.uniquindio.unicine.servicios.implementacion.UsuarioServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de prueba para los servicios de un cliente
 */
@SpringBootTest
@Transactional
public class ClienteTest {

    @Autowired
    private ClienteServicioImpl clienteServicio;
    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    /**
     * Metodo de prueba para rgeistrar un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCliente() {
        Usuario usuario = new Usuario("nicovalencia13","123456", Rol.Cliente);
        Cliente cliente = new Cliente("1094970202","Nicolas Valencia","nicolasvalencibnmbnaghjmadrid@gmail.com","RUTA", Estado.Inactivo, usuario);
        try {
            usuarioServicio.registrarUsuario(usuario);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
        try {
            Cliente almacenado = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * Metodo de prueba para actualizar un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCliente() {
        Cliente cliente = null;
        try {
            cliente = clienteServicio.consultarCliente(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
        cliente.setNombre("pepito");
        try {
            Cliente almacenado = clienteServicio.actualizarCliente(cliente);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * Metodo de prueba para eliminar un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCliente() {
        try {
            clienteServicio.eliminarCliente(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * Metodo de prueba para listar los clientes
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientes() {
        List<Cliente> clientes = clienteServicio.listarClientes();
        Assertions.assertTrue(true);
    }

    /**
     * Metodo de prueba para consultar un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarCliente() {
        try {
            Cliente cliente = clienteServicio.consultarCliente(1);
            Assertions.assertNotNull(cliente);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * Metodo de prueba para listar ciudades
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades() {
        List<Ciudad> ciudades = clienteServicio.listarCiudades();
        Assertions.assertNotNull(ciudades);
    }

    /**
     * Metodo de prueba para listar los teatros de una ciudad
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatrosCiudad() {
        try {
            List<Teatro> teatros =clienteServicio.listarTeatrosCiudad(1);
            Assertions.assertNotNull(teatros);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * Metodo de prueba para listar las peliculas en cartelera y preventa
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculasCartelera() {
        try {
            List<Pelicula> peliculas = clienteServicio.listarPeliculasCartelera(1);
            Assertions.assertNotNull(peliculas);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * Metodo de prueba para listar las funciones de una pelicula
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarFuncionesPelicula() {
        try {
            List<Funcion> funciones = clienteServicio.listarFuncionesPelicula(1,1);
            Assertions.assertNotNull(funciones);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
}
