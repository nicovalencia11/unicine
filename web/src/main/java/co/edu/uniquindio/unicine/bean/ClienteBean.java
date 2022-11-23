package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.enums.Rol;
import co.edu.uniquindio.unicine.servicios.servicios.ClienteServicio;
import co.edu.uniquindio.unicine.servicios.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class ClienteBean implements Serializable {

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Usuario usuario;

    @Getter @Setter
    private String confirmarContrasenia;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializarClase() {
        cliente = new Cliente();
        usuario = new Usuario();
        cliente.setUsuario(usuario);
    }

    public void registrarCliente() {
        try {
            if(cliente.getUsuario().getPassword().equals(confirmarContrasenia)){

                usuario.setNombreUsuario(cliente.getCedula());
                usuario.setRol(Rol.Cliente);
                usuario = usuarioServicio.registrarUsuario(usuario);
                cliente.setUsuario(usuario);
                clienteServicio.registrarCliente(cliente);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Registro exitoso!", "Bienvenido, ingresa al enlace de confirmación enviado a tu correo.");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);

            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Registro exitoso!", "Las contraseñas no coinciden");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificación", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

}
