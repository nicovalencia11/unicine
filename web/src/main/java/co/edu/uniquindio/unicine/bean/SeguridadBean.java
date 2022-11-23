package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.servicios.servicios.ClienteServicio;
import co.edu.uniquindio.unicine.servicios.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String correo, password;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Usuario usuario;

    @Getter @Setter
    private String tipoSesion;

    @Getter @Setter
    private Ciudad ciudad;
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Email
    @Getter @Setter
    private String email;

    @PostConstruct
    public void init() {
        autenticado = false;
    }

    public String iniciarSesionCliente() {

        if (!correo.isEmpty() && !password.isEmpty()) {
            try {
                usuario = usuarioServicio.loginCorreo(correo, password);
                cliente = usuario.getCliente();
                tipoSesion = "cliente";
                autenticado = true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificacion", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificacion", "La cedula y la contraseña son obligatorios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String cerrarSesion() {
        String tipo = tipoSesion;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        if (tipo.equals("cliente")) {
            autenticado = false;
            return "/index?faces-redirect=true";
        }
        return "/index_admin?faces-redirect=true";
    }

}
