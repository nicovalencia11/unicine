package co.edu.uniquindio.unicine.servicios.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

/**
 * Interface con los metodos abstratos para el administrador
 * del sistema
 */
public interface AdminServicio {

    /**
     * Metodo que permite registrar una pelicula
     * @param pelicula
     * @return
     * @throws Exception
     */
    Pelicula registrarPelicula(Pelicula pelicula) throws Exception;

    /**
     * Metodo que permite actualizar una pelicula
     * @param pelicula
     * @return
     * @throws Exception
     */
    Pelicula actualizarPelicula(Pelicula pelicula) throws Exception;

    /**
     * Metodo que permite eliminar una pelicula
     * @param codigoPelicula
     * @throws Exception
     */
    void eliminarPelicula(Integer codigoPelicula) throws Exception;

    /**
     * Metodo que permite listar las pelicula
     * @return
     */
    List<Pelicula> listarPeliculas();

    /**
     * Metodo que permite consultar una pelicula dado su id
     * @param codigoPelicula
     * @return
     * @throws Exception
     */
    Pelicula consultarPelicula(Integer codigoPelicula) throws Exception;

    /**
     * Metodo que permite registrar la confiteria
     * @param confiteria
     * @return
     * @throws Exception
     */
    Confiteria registrarConfiteria(Confiteria confiteria) throws Exception;

    /**
     * Metodo que permite actualizar una confiteria
     * @param confiteria
     * @return
     * @throws Exception
     */
    Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception;

    /**
     * Metodo que permite eliminar una confiteria
     * @param codigoConfiteria
     * @throws Exception
     */
    void eliminarConfiteria(Integer codigoConfiteria) throws Exception;

    /**
     * Metodo que permite listar las confiterias
     * @return
     */
    List<Confiteria> listarConfiterias();

    /**
     * Metodo que permite consultar una confiteria dado su id
     * @param codigoConfiteria
     * @return
     * @throws Exception
     */
    Confiteria consultarConfiteria(Integer codigoConfiteria) throws Exception;

    /**
     * Metodo que permite registrar un cupon
     * @param cupon
     * @return
     * @throws Exception
     */
    Cupon registrarCupon(Cupon cupon) throws Exception;

    /**
     * Metodo que permite actualizar un cupon
     * @param cupon
     * @return
     * @throws Exception
     */
    Cupon actualizarCupon(Cupon cupon) throws Exception;

    /**
     * Metodo que permite eliminar un cupon
     * @param codigoCupon
     * @throws Exception
     */
    void eliminarCupon(Integer codigoCupon) throws Exception;

    /**
     * Metodo que permite listar los cupones
     * @return
     */
    List<Cupon> listarCupones();

    /**
     * Metodo que permite consultar un cupon dado su id
     * @param codigoCupon
     * @return
     * @throws Exception
     */
    Cupon consultarCupon(Integer codigoCupon) throws Exception;

    /**
     * Metodo que permite registrar una ciudad
     * @param ciudad
     * @return
     * @throws Exception
     */
    Ciudad registrarCiudad(Ciudad ciudad) throws Exception;

    /**
     * Metodo que permite actualizar una ciudad
     * @param ciudad
     * @return
     * @throws Exception
     */
    Ciudad actualizarCiudad(Ciudad ciudad) throws Exception;

    /**
     * metodo que permite eliminar una ciudad
     * @param codigoCiudad
     * @throws Exception
     */
    void eliminarCiudad(Integer codigoCiudad) throws Exception;

    /**
     * Metodo que permite listar todas las ciudades
     * @return
     */
    List<Ciudad> listarCiudades();

    /**
     * Metodo que permite consultar una ciudad dado su id
     * @param codigoCiudad
     * @return
     * @throws Exception
     */
    Ciudad consultarCiudad(Integer codigoCiudad) throws Exception;

    /**
     * Metodo que permite registrar el empleado
     * @param empleado
     * @return
     * @throws Exception
     */
    Empleado registrarEmpleado(Empleado empleado) throws Exception;

    /**
     * Metodo que permite acxtualizar el empleado
     * @param empleado
     * @return
     * @throws Exception
     */
    Empleado actualizarEmpleado(Empleado empleado) throws Exception;

    /**
     * Metodo que permite eliminar un empleado
     * @param codigoEmpleado
     * @throws Exception
     */
    void eliminarEmpleado(Integer codigoEmpleado) throws Exception;

    /**
     * Metodo que permite listar los empleados
     * @return
     */
    List<Empleado> listarEmpleados();

    /**
     * Metodo que permite  consultar un empleado dado su codigo
     * @param codigoEmpleado
     * @return
     * @throws Exception
     */
    Empleado consultarEmpleado(Integer codigoEmpleado) throws Exception;

}
