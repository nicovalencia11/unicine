package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repositorios.CiudadRepositorio;
import co.edu.uniquindio.unicine.repositorios.TeatroRepositorio;
import co.edu.uniquindio.unicine.servicios.implementacion.AdminTeatroServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase de pruebas unitarias para los servicios de un administrador de teatro
 */
@SpringBootTest
@Transactional
public class AdminTeatroTest {

    @Autowired
    private AdminTeatroServicioImpl adminTeatroServicio;
    @Autowired
    private CiudadRepositorio ciudadRepositorio;
    @Autowired
    private TeatroRepositorio teatroRepositorio;

    /**
     * Metodo de prueba para registrar un teatro
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarTeatro() {
        Ciudad ciudad = ciudadRepositorio.findById(1).orElse(null);
        Teatro teatro =
                new Teatro("Unicentro",
                        "Centro comercial unicentro piso 3",
                        "3217802697",
                        ciudad);
        try {
            adminTeatroServicio.registrarTeatro(teatro);
            Assertions.assertNotNull(teatro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo de prueba para actualizar un teatro
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTeatro() {
        Teatro teatro = null;
        try {
            teatro = adminTeatroServicio.consultarTeatro(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        teatro.setNombre("Nuevo teatro");

        try {
            Teatro teatroAlmacenado = adminTeatroServicio.actualizarTeatro(teatro);
            Assertions.assertNotNull(teatroAlmacenado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo de prueba para eliminar un teatro
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTeatro() {
        try {
            adminTeatroServicio.eliminarTeatro(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo de prueba para listar todos los teatros
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatros() {
        List<Teatro> teatros = adminTeatroServicio.listarTeatros();
        Assertions.assertNotNull(teatros);
    }

    /**
     * Metodo de prueba para consultar un teatro
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarTeatro() {
        try {
            Teatro teatro = adminTeatroServicio.consultarTeatro(1);
            Assertions.assertNotNull(teatro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo de prueba para registrar una sala
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarSala() {
        Teatro teatro = teatroRepositorio.findById(1).orElse(null);
        Sala sala = new Sala("SALA 1", "{}", teatro);
        try {
            sala = adminTeatroServicio.registrarSala(sala);
            Assertions.assertNotNull(sala);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo de prueba para actualizar una sala
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarSala() {
        Sala sala = null;
        try {
            sala = adminTeatroServicio.consultarSala(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sala.setDescripcion("SALA 2");
        try {
            sala = adminTeatroServicio.actualizarSala(sala);
            Assertions.assertNotNull(sala);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo de prueba para eliminar la sala
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarSala() {
        try {
            adminTeatroServicio.eliminarSala(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo de prueba para listar las salas
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSalas() {
        List<Sala> salas = adminTeatroServicio.listarSalas();
        Assertions.assertNotNull(salas);
    }

    /**
     * metodo de prueba para consultar las salas
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void consultarSala() {
        Sala sala = null;
        try {
            sala = adminTeatroServicio.consultarSala(1);
            Assertions.assertNotNull(sala);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
