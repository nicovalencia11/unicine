package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.enums.Rol;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

/**
 * Prueba unitaria para probar el repositorio del cliente
 * y las entidades relacionadas con el cliente
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    /**
     * Metodo encargado de probar el registro de un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Usuario usuario = new Usuario("nicovalencia11","123456", Rol.Cliente);
        Cliente cliente = new Cliente("1094970200","Nicolas Valencia","nicolasvalenciamadrid@gmail.com","RUTA", Estado.Inactivo, usuario);
        Cliente clienteR = clienteRepositorio.save(cliente);
        Assertions.assertNotNull(clienteR);
    }

    /**
     * Metodo encargado de probar el borrado de un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Optional<Cliente> response = clienteRepositorio.findById(1);
        Cliente cliente = response.orElse(null);
        clienteRepositorio.delete(cliente);
        Optional<Cliente> clienteB = clienteRepositorio.findById(1);
        Assertions.assertNull(clienteB.orElse(null));
    }

    /**
     * Metodo encargado de probar la edicion de un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Cliente cliente = clienteRepositorio.findById(1).orElse(null);
        cliente.setCorreo("nuevo@gmail.com");
        cliente = clienteRepositorio.save(cliente);
        Assertions.assertEquals("nuevo@gmail.com",cliente.getCorreo());
    }

    /**
     * Metodo encargado de probar el findbyid de cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Cliente> clienteB = clienteRepositorio.findById(1);
        Assertions.assertNotNull(clienteB.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerByEmail(){
        Cliente cliente = clienteRepositorio.obtener("juan@gmail.com");
        Assertions.assertNotNull(cliente);
    }

    /**
     * Metodo encargado de probar el find all clientes
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cliente> clientes = clienteRepositorio.findAll();
        Assertions.assertNotNull(clientes);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCuponesCliente(){
        List<Cupon> cupones = clienteRepositorio.listarCuponesCliente("nicolasvalenciamadrid@gmail.com");
        cupones.forEach(System.out::println);
        Assertions.assertNotNull(cupones);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerClientesCompras(){
        List<Object[]> clientesCompras = clienteRepositorio.obtenerComprasTodos();
        clientesCompras.forEach(objects ->
                System.out.println(objects[0] + " - " + objects[1]));
        Assertions.assertNotNull(clientesCompras);
    }

}
