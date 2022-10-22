package co.edu.uniquindio.unicine.servicios.implementacion;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.*;
import co.edu.uniquindio.unicine.servicios.servicios.AdminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio con la implementacion de los metodos para los administradores
 */
@Service
public class AdminServicioImpl implements AdminServicio {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @Autowired
    private ConfiteriaRepositorio confiteriaRepositorio;

    @Autowired
    private CuponRepositorio cuponRepositorio;

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    /**
     * Metodo que permite registrar una pelicula
     *
     * @param pelicula
     * @return
     * @throws Exception
     */
    @Override
    public Pelicula registrarPelicula(Pelicula pelicula) throws Exception {
        Pelicula peliculaBuscada = consultarPelicula(pelicula.getCodigo());

        if(peliculaBuscada != null)
        {
            throw new Exception("La pelicula ya está registrada en el sistema");

        }
        return peliculaRepositorio.save(pelicula);
    }

    /**
     * Metodo que permite actualizar una pelicula
     *
     * @param pelicula
     * @return
     * @throws Exception
     */
    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        verificarCodigoPelicula(pelicula.getCodigo());
        return peliculaRepositorio.save(pelicula);
    }

    /**
     * Metodo que permite eliminar una pelicula
     *
     * @param codigoPelicula
     * @throws Exception
     */
    @Override
    public void eliminarPelicula(Integer codigoPelicula) throws Exception {
        Pelicula pelicula = consultarPelicula(codigoPelicula);
        peliculaRepositorio.delete(pelicula);
    }

    /**
     * Metodo que permite listar las pelicula
     *
     * @return
     */
    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar una pelicula dado su id
     *
     * @param codigoPelicula
     * @return
     * @throws Exception
     */
    @Override
    public Pelicula consultarPelicula(Integer codigoPelicula) throws Exception {
        verificarCodigoPelicula(codigoPelicula);
        return peliculaRepositorio.findById(codigoPelicula).orElse(null);
    }

    /**
     * * Metodo que permite verificar si una pelicula existe dado su id
     * @param codigoPelicula
     *  @throws Exception
     */

    private void verificarCodigoPelicula(Integer codigoPelicula) throws Exception {

        Pelicula peliculaGuardada = peliculaRepositorio.findById(codigoPelicula).orElse(null);
        if (peliculaGuardada == null){
            throw new Exception("La pelicula no existe en el sistema");
        }
    }

    /**
     * Metodo que permite registrar la confiteria
     *
     * @param confiteria
     * @return
     * @throws Exception
     */
    @Override
    public Confiteria registrarConfiteria(Confiteria confiteria) throws Exception {
        Confiteria confiteriaBuscada = consultarConfiteria(confiteria.getCodigo());

        if(confiteriaBuscada != null)
        {
            throw new Exception("La pelicula ya está registrada en el sistema");
        }

        return confiteriaRepositorio.save(confiteria);
    }

    /**
     * Metodo que permite actualizar una confiteria
     *
     * @param confiteria
     * @return
     * @throws Exception
     */
    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        verificarCodigoConfiteria(confiteria.getCodigo());
        return confiteriaRepositorio.save(confiteria);
    }

    /**
     * Metodo que permite eliminar una confiteria
     *
     * @param codigoConfiteria
     * @throws Exception
     */
    @Override
    public void eliminarConfiteria(Integer codigoConfiteria) throws Exception {
        Confiteria confiteria = consultarConfiteria(codigoConfiteria);
        confiteriaRepositorio.delete(confiteria);
    }

    /**
     * Metodo que permite listar las confiterias
     *
     * @return
     */
    @Override
    public List<Confiteria> listarConfiterias() {
        return confiteriaRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar una confiteria dado su id
     *
     * @param codigoConfiteria
     * @return
     * @throws Exception
     */
    @Override
    public Confiteria consultarConfiteria(Integer codigoConfiteria) throws Exception {
        verificarCodigoConfiteria(codigoConfiteria);
        return confiteriaRepositorio.findById(codigoConfiteria).orElse(null);
    }

    /**
     * * Metodo que permite verificar si una pelicula existe dado su id
     * @param codigoConfiteria
     *  @throws Exception
     */

    private void verificarCodigoConfiteria(Integer codigoConfiteria) throws Exception {

        Confiteria confiteriaGuardada = confiteriaRepositorio.findById(codigoConfiteria).orElse(null);
        if (confiteriaGuardada == null){
            throw new Exception("La confiteria no existe en el sistema");
        }
    }

    /**
     * Metodo que permite registrar un cupon
     *
     * @param cupon
     * @return
     * @throws Exception
     */
    @Override
    public Cupon registrarCupon(Cupon cupon) throws Exception {
        Cupon cuponBuscado = consultarCupon(cupon.getCodigo());

        if(cuponBuscado != null)
        {
            throw new Exception("El cupon ya está registrado en el sistema");

        }
        return cuponRepositorio.save(cupon);
    }

    /**
     * Metodo que permite actualizar un cupon
     *
     * @param cupon
     * @return
     * @throws Exception
     */
    @Override
    public Cupon actualizarCupon(Cupon cupon) throws Exception {
        verificarCodigoCupon(cupon.getCodigo());
        return cuponRepositorio.save(cupon);
    }

    /**
     * Metodo que permite eliminar un cupon
     *
     * @param codigoCupon
     * @throws Exception
     */
    @Override
    public void eliminarCupon(Integer codigoCupon) throws Exception {
        Cupon cupon = consultarCupon(codigoCupon);
        cuponRepositorio.delete(cupon);
    }

    /**
     * Metodo que permite listar los cupones
     *
     * @return
     */
    @Override
    public List<Cupon> listarCupones() {
        return cuponRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar un cupon dado su id
     *
     * @param codigoCupon
     * @return
     * @throws Exception
     */
    @Override
    public Cupon consultarCupon(Integer codigoCupon) throws Exception {
        verificarCodigoCupon(codigoCupon);
        return cuponRepositorio.findById(codigoCupon).orElse(null);
    }

    /**
     * * Metodo que permite verificar si un cupon existe dado su id
     * @param codigoCupon
     *  @throws Exception
     */

    private void verificarCodigoCupon(Integer codigoCupon) throws Exception {

        Cupon cuponGuardado = cuponRepositorio.findById(codigoCupon).orElse(null);
        if (cuponGuardado == null){
            throw new Exception("El cupón no existe en el sistema");
        }
    }


    /**
     * Metodo que permite registrar una ciudad
     *
     * @param ciudad
     * @return
     * @throws Exception
     */
    @Override
    public Ciudad registrarCiudad(Ciudad ciudad) throws Exception {
        Ciudad ciudadBuscada = consultarCiudad(ciudad.getCodigo());

        if(ciudadBuscada != null)
        {
            throw new Exception("La ciudad ya está registrado en el sistema");

        }
        return ciudadRepositorio.save(ciudad);
    }

    /**
     * Metodo que permite actualizar una ciudad
     *
     * @param ciudad
     * @return
     * @throws Exception
     */
    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        verificarCodigoCiudad(ciudad.getCodigo());
        return ciudadRepositorio.save(ciudad);
    }

    /**
     * metodo que permite eliminar una ciudad
     *
     * @param codigoCiudad
     * @throws Exception
     */
    @Override
    public void eliminarCiudad(Integer codigoCiudad) throws Exception {
        Ciudad ciudad = consultarCiudad(codigoCiudad);
        ciudadRepositorio.delete(ciudad);

    }

    /**
     * Metodo que permite listar todas las ciudades
     *
     * @return
     */
    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar una ciudad dado su id
     *
     * @param codigoCiudad
     * @return
     * @throws Exception
     */
    @Override
    public Ciudad consultarCiudad(Integer codigoCiudad) throws Exception {
        verificarCodigoCiudad(codigoCiudad);
        return ciudadRepositorio.findById(codigoCiudad).orElse(null);
    }

    /**
     * * Metodo que permite verificar si una ciudad existe dado su id
     * @param codigoCiudad
     *  @throws Exception
     */
    private void verificarCodigoCiudad(Integer codigoCiudad) throws Exception {

        Ciudad ciudadGuardada = ciudadRepositorio.findById(codigoCiudad).orElse(null);
        if (ciudadGuardada == null){
            throw new Exception("La confiteria no existe en el sistema");
        }
    }



    /**
     * Metodo que permite registrar el empleado
     *
     * @param empleado
     * @return
     * @throws Exception
     */
    @Override
    public Empleado registrarEmpleado(Empleado empleado) throws Exception {
        return null;
    }

    /**
     * Metodo que permite acxtualizar el empleado
     *
     * @param empleado
     * @return
     * @throws Exception
     */
    @Override
    public Empleado actualizarEmpleado(Empleado empleado) throws Exception {
        return null;
    }

    /**
     * Metodo que permite eliminar un empleado
     *
     * @param codigoEmpleado
     * @throws Exception
     */
    @Override
    public void eliminarEmpleado(Integer codigoEmpleado) throws Exception {

    }

    /**
     * Metodo que permite listar los empleados
     *
     * @return
     */
    @Override
    public List<Empleado> listarEmpleados() {
        return null;
    }

    /**
     * Metodo que permite  consultar un empleado dado su codigo
     *
     * @param codigoEmpleado
     * @return
     * @throws Exception
     */
    @Override
    public Empleado consultarEmpleado(Integer codigoEmpleado) throws Exception {
        return null;
    }
}
