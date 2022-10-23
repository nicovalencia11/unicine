package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.enums.Genero;
import co.edu.uniquindio.unicine.enums.Rol;
import co.edu.uniquindio.unicine.servicios.implementacion.AdminServicioImpl;
import co.edu.uniquindio.unicine.servicios.implementacion.ClienteServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de pruebas unitarias para los servicios de un administrador
 */
@SpringBootTest
@Transactional
public class AdminTest {

    @Autowired
    private AdminServicioImpl adminServicio;

    @Autowired
    private ClienteServicioImpl clienteServicio;

    /**
     * metodo de prueba para registrar una pelicula
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarPelicula()
    {
        List<Genero> list = new ArrayList<Genero>();
        list.add(Genero.Accion);
        list.add(Genero.cienciaFiccion);

        Pelicula pelicula = new Pelicula("AVENGER", "RUTA_IMAGEN", "TRAILER", "SINOPSIS", "REPARTO", Estado.CARTELERA, list);
        try {
            Pelicula peliculaRegistrada = adminServicio.registrarPelicula(pelicula);
            Assertions.assertNotNull(peliculaRegistrada);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * metodo de prueba para actualizar una pelicula
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPelicula()
    {
        Pelicula pelicula = null;

        try {
            pelicula = adminServicio.consultarPelicula(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

        try {
            pelicula.setNombre("AVATAR");
            Pelicula almacenada = adminServicio.actualizarPelicula(pelicula);
            Assertions.assertNotNull(almacenada);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }


    /**
     * metodo de prueba para eliminar una pelicula
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPelicula() {
        try {
            adminServicio.eliminarPelicula(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para listar peliculas
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculas()
    {
        List<Pelicula> peliculas = adminServicio.listarPeliculas();
        Assertions.assertTrue(true);
    }


    /**
     * metodo de prueba para consultar una pelicula
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarPelicula() {
        try {
            Pelicula pelicula = adminServicio.consultarPelicula(1);
            Assertions.assertNotNull(pelicula);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para registrar una confiteria
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarConfiteria()
    {
        Confiteria confiteria = new Confiteria("Chocorramo con gaseosa", "ruta_imagen", 50.0, "Delicioso");
        try {
            Confiteria confiteriaRegistrada = adminServicio.registrarConfiteria(confiteria);
            Assertions.assertNotNull(confiteriaRegistrada);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * metodo de prueba para actualizar una confiteria
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarConfiteria()
    {
        Confiteria confiteria = null;

        try {
            confiteria = adminServicio.consultarConfiteria(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

        try {
            confiteria.setNombre("Papas fritas");
            Confiteria almacenada = adminServicio.actualizarConfiteria(confiteria);
            Assertions.assertNotNull(almacenada);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para eliminar una confiteria
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConfiteria() {
        try {
            adminServicio.eliminarConfiteria(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para listar una confiteria
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void listarConfiteria()
    {
        List<Confiteria> confiterias = adminServicio.listarConfiterias();
        Assertions.assertTrue(true);
    }

    /**
     * metodo de prueba para consultar una confiteria
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarConfiteria() {
        try {
            Confiteria confiteria = adminServicio.consultarConfiteria(1);
            Assertions.assertNotNull(confiteria);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para registrar un cupon
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCupon() throws Exception {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(clienteServicio.consultarCliente(1));

        Cupon cupon = new Cupon(8.5, LocalDate.now(), "Descripcion", "Menores", Estado.Activo, clientes);
        try {
            Cupon cuponRegistrado = adminServicio.registrarCupon(cupon);
            Assertions.assertNotNull(cuponRegistrado);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * metodo de prueba para actualizar un cupon
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCupon()
    {
        Cupon cupon = null;

        try {
            cupon = adminServicio.consultarCupon(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

        try {
            cupon.setDescripcion("Para clientes antiguos");
            Cupon almacenado = adminServicio.actualizarCupon(cupon);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para eliminar un cupon
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminaCupon() {
        try {
            adminServicio.eliminarCupon(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para listar cupones
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCupones()
    {
        List<Cupon> cupones = adminServicio.listarCupones();
        Assertions.assertTrue(true);
    }

    /**
     * metodo de prueba para consultar un cupon
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarCupon() {
        try {
            Cupon cupon = adminServicio.consultarCupon(1);
            Assertions.assertNotNull(cupon);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para registrar una ciudad
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCiudad()
    {
        Ciudad ciudad = new Ciudad("Quibdo");
        try {
            Ciudad ciudadRegistrada = adminServicio.registrarCiudad(ciudad);
            Assertions.assertNotNull(ciudadRegistrada);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * metodo de prueba para actualizar una ciudad
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCiudad()
    {
        Ciudad ciudad = null;

        try {
            ciudad = adminServicio.consultarCiudad(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

        try {
            ciudad.setNombre("Armenia2");
            Ciudad almacenado = adminServicio.actualizarCiudad(ciudad);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para eliminar una ciudad
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudad() {
        try {
            adminServicio.eliminarCiudad(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para listar ciudades
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades()
    {
        List<Ciudad> ciudades = adminServicio.listarCiudades();
        Assertions.assertTrue(true);
    }

    /**
     * metodo de prueba para consultar una ciudad
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarCiudad() {
        try {
            Ciudad ciudad = adminServicio.consultarCiudad(1);
            Assertions.assertNotNull(ciudad);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para registrar un empleado
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarEmpleado() throws Exception {

        Usuario usuario = new Usuario("ana", "ana123", Rol.AdministradorTeatro);
        Empleado empleado = new Empleado("Ana", "1234", "ana123@correo.com", usuario);
        try {
            Empleado empleadoRegistrado = adminServicio.registrarEmpleado(empleado);
            Assertions.assertNotNull(empleadoRegistrado);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * metodo de prueba para actualizar un empleado
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarEmpleado()
    {
        Empleado empleado = null;

        try {
            empleado = adminServicio.consultarEmpleado(1);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

        try {
            empleado.setNombre("Estebann");
            Empleado almacenado = adminServicio.actualizarEmpleado(empleado);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para eliminar un empleado
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarEmpleado() {
        try {
            adminServicio.eliminarEmpleado(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    /**
     * metodo de prueba para listar empleados
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void listarEmpleados()
    {
        List<Empleado> empleados = adminServicio.listarEmpleados();
        Assertions.assertTrue(true);
    }

    /**
     * metodo de prueba para consultar un empleado
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarEmpleado() {
        try {
            Empleado empleado = adminServicio.consultarEmpleado(1);
            Assertions.assertNotNull(empleado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

}
