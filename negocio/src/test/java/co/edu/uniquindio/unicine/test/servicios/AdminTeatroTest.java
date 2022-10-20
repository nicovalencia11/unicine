package co.edu.uniquindio.unicine.test.servicios;

import co.edu.uniquindio.unicine.servicios.implementacion.AdminTeatroServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AdminTeatroTest {

    @Autowired
    private AdminTeatroServicioImpl adminTeatroServicio;

}
