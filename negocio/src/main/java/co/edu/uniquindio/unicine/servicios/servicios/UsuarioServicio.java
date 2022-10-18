package co.edu.uniquindio.unicine.servicios.servicios;

import co.edu.uniquindio.unicine.entidades.Usuario;

import java.util.List;

/**
 * Interface con los metodos abstratos para el servicio de usuarios
 */
public interface UsuarioServicio {

    /**
     * Metodo que permite el login de un usuario con correo y contraseña
     * @param correo
     * @param password
     * @return
     * @throws Exception
     */
    Usuario loginCorreo(String correo, String password) throws Exception;

    /**
     * Metodo que permite el login con nombre de usuario y contraseña
     * @param nombreUsuario
     * @param password
     * @return
     */
    Usuario loginUsuario(String nombreUsuario, String password) throws Exception;

    /**
     * Metodo que permite registrar un usuario
     * @param usuario
     * @return
     */
    Usuario registrarUsuario(Usuario usuario) throws Exception;

    /**
     * Metodo que permite actualizar un usuario
     * @param usuario
     * @return
     */
    Usuario actualizarUsuario(Usuario usuario) throws Exception;

    /**
     * Metodo que permite eliminar un usuario
     * @param codigoUsuario
     */
    void eliminarUsuario(Integer codigoUsuario) throws Exception;

    /**
     * metodo que permite listar todos los usuarios
     * @return
     */
    List<Usuario> listarUsuarios();

    /**
     * Metodo que permite consultar un usuario con su codigo
     * @param codigoUsuario
     * @return
     */
    Usuario consultarUsuario(Integer codigoUsuario) throws Exception;
}
