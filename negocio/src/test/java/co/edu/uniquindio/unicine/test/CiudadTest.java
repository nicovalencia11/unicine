package co.edu.uniquindio.unicine.test;


import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.repositorios.CiudadRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadesDepartamento(){

        List<Ciudad> ciudades = ciudadRepositorio.obtenerCiudadesByDepartamento("Quindio");
        ciudades.forEach(System.out::println);
        Assertions.assertNotNull(ciudades);
    }

}
