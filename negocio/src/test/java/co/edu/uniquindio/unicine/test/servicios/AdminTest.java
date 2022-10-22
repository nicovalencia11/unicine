package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.servicios.implementacion.AdminServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase de pruebas unitarias para los servicios de un administrador
 */
@SpringBootTest
@Transactional
public class AdminTest {

    @Autowired
    private AdminServicioImpl adminServicio;

}
