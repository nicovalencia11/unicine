package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * Clase para las pruebas unitarias de la entidad y el repositorio usuario
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion(){
        Usuario usuario = usuarioRepositorio.findByNombreUsuarioAndPassword("nicovalencia11", "nico123");
        Assertions.assertNotNull(usuario);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginador(){
        List<Usuario> usuarios = usuarioRepositorio.findAll(PageRequest.of(1,2)).toList();
        usuarios.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ordenarRegistros(){
        List<Usuario> usuarios = usuarioRepositorio.findAll(Sort.by("nombreUsuario"));
        usuarios.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginarOrdenarRgistros(){
        List<Usuario> usuarios = usuarioRepositorio.findAll(PageRequest.of(1,2, Sort.by("nombreUsuario"))).toList();
        usuarios.forEach(System.out::println);
    }
}
