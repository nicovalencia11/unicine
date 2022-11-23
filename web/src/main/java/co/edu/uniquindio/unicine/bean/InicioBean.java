package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter
    @Setter
    private List<Pelicula> peliculasCartelera;


    @PostConstruct
    public void init() {
        try {
            peliculasCartelera = clienteServicio.listarPeliculasCartelera(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
