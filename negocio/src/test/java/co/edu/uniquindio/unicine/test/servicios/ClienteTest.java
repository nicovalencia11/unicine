package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.enums.Rol;
import co.edu.uniquindio.unicine.servicios.implementacion.ClienteServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ClienteTest {

    @Autowired
    private ClienteServicioImpl clienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCliente() {
        Usuario usuario = new Usuario("nicovalencia11","123456", Rol.Cliente);
        Cliente cliente = new Cliente("1094970201","Nicolas Valencia","nicolasvalencibnmbnamadrid@gmail.com","RUTA", Estado.Inactivo, usuario);
        try {
            Cliente almacenado = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

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

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientes() {
        List<Cliente> clientes = clienteServicio.listarClientes();
        Assertions.assertTrue(true);
    }

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

}
