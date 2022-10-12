package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.dtos.FuncionDTO;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.repositorios.FuncionRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {

    @Autowired
    private FuncionRepositorio funcionRepositorio;


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNombrePeliculaFuncion(){
        String nombrePelicula = funcionRepositorio.obtenerNombrePelicula(3);
        System.out.println(nombrePelicula);
        Assertions.assertNotNull(nombrePelicula);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerInfoPelicula(){
        List<FuncionDTO> funciones = funcionRepositorio.listarFunciones(1);
        funciones.forEach(System.out::println);
        Assertions.assertNotNull(funciones);
    }
}
