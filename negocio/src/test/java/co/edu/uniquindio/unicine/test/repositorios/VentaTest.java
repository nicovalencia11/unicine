package co.edu.uniquindio.unicine.test.repositorios;

import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.entidades.Venta;
import co.edu.uniquindio.unicine.repositorios.VentaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VentaTest {

    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void ventasClientePorCorreo(){
        List<Venta> ventas = ventaRepositorio.ventasPorEmailUsuario("nicolasvalenciamadrid@gmail.com");
        ventas.forEach(System.out::println);
        Assertions.assertNotNull(ventas);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void entradasCompra(){
        List<Entrada> entradas = ventaRepositorio.entradasPorCompra(1);
        entradas.forEach(System.out::println);
        Assertions.assertNotNull(entradas);
    }
}
