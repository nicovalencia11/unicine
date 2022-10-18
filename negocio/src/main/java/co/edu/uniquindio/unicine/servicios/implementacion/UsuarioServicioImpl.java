package co.edu.uniquindio.unicine.servicios.implementacion;

import co.edu.uniquindio.unicine.entidades.Usuario;
import co.edu.uniquindio.unicine.repositorios.UsuarioRepositorio;
import co.edu.uniquindio.unicine.servicios.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * servicio con la implementacion de los metodos de un usuario
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /**
     * Metodo que permite el login de un usuario con correo y contraseña
     *
     * @param correo
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public Usuario loginCorreo(String correo, String password) throws Exception {
        Usuario usuario = usuarioRepositorio.login(correo,password);
        if (usuario == null){
            throw new Exception("Los datos de autenticacion no son correctos");
        }
        return usuario;
    }

    /**
     * Metodo que permite el login con nombre de usuario y contraseña
     *
     * @param nombreUsuario
     * @param password
     * @return
     */
    @Override
    public Usuario loginUsuario(String nombreUsuario, String password) throws Exception {
        Usuario usuario = usuarioRepositorio.findByNombreUsuarioAndPassword(nombreUsuario,password);
        if (usuario == null){
            throw new Exception("Los datos de autenticacion no son correctos");
        }
        return usuario;
    }

    /**
     * Metodo que permite registrar un usuario
     *
     * @param usuario
     * @return
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        if(verificarCorreo(usuario.getCliente().getCorreo(),usuario.getNombreUsuario())){
            throw new Exception("El correo o nombre de usuario ya se encuentra registrado en el sistema");
        }
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Metodo que permite actualizar un usuario
     *
     * @param usuario
     * @return
     */
    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        verificarCodigo(usuario.getCodigo());
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Metodo que permite eliminar un usuario
     *
     * @param codigoUsuario
     */
    @Override
    public void eliminarUsuario(Integer codigoUsuario) throws Exception {
        verificarCodigo(codigoUsuario);
        usuarioRepositorio.deleteById(codigoUsuario);
    }

    /**
     * metodo que permite listar todos los usuarios
     *
     * @return
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar un usuario con su codigo
     *
     * @param codigoUsuario
     * @return
     */
    @Override
    public Usuario consultarUsuario(Integer codigoUsuario) throws Exception {
        verificarCodigo(codigoUsuario);
        return usuarioRepositorio.findById(codigoUsuario).orElse(null);
    }

    /**
     * Metodo que permite verificar si un correo ya existe en la base de datos
     * @param correo
     * @return
     */
    private boolean verificarCorreo(String correo, String nombreUsuario) {
        Usuario usuario = usuarioRepositorio.verificarCorreoNombreUsuario(correo, nombreUsuario).orElse(null);
        if(usuario == null){
            return false;
        }
        return true;
    }

    /**
     * Metodo que permite verificar si un usuario existe dado su id
     * @param codigoUsuario
     * @throws Exception
     */
    private void verificarCodigo(Integer codigoUsuario) throws Exception {
        Usuario usuarioGuardado = usuarioRepositorio.findById(codigoUsuario).orElse(null);
        if (usuarioGuardado == null){
            throw new Exception("El usuario no existe en el sistema");
        }
    }
}
