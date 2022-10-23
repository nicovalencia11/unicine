package co.edu.uniquindio.unicine.servicios.implementacion;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.CiudadRepositorio;
import co.edu.uniquindio.unicine.repositorios.SalaRepositorio;
import co.edu.uniquindio.unicine.repositorios.TeatroRepositorio;
import co.edu.uniquindio.unicine.servicios.servicios.AdminTeatroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio con la implementacion de los metodos para el administrador del teatro
 */
@Service
public class AdminTeatroServicioImpl implements AdminTeatroServicio {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;
    @Autowired
    private TeatroRepositorio teatroRepositorio;
    @Autowired
    private SalaRepositorio salaRepositorio;



    /**
     * Metodo que permite registrar el teatro
     *
     * @param teatro
     * @return
     * @throws Exception
     */
    @Override
    public Teatro registrarTeatro(Teatro teatro) throws Exception {
        validarInformacionTeatro(teatro);
        return teatroRepositorio.save(teatro);
    }

    /**
     * Metodo que permite actualizar un teatro
     *
     * @param teatro
     * @return
     * @throws Exception
     */
    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {
        verificarCodigoTeatro(teatro.getCodigo());
        return teatroRepositorio.save(teatro);
    }

    /**
     * Metodo que permite permite eliminar un teatro por su id
     *
     * @param codigoTeatro
     * @throws Exception
     */
    @Override
    public void eliminarTeatro(Integer codigoTeatro) throws Exception {
        verificarCodigoTeatro(codigoTeatro);
        teatroRepositorio.deleteById(codigoTeatro);
    }

    /**
     * Metodo que permite listar todos los teatros existentes
     *
     * @return
     */
    @Override
    public List<Teatro> listarTeatros() {
        return teatroRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar un teatro
     *
     * @param codigoTeatro
     * @return
     * @throws Exception
     */
    @Override
    public Teatro consultarTeatro(Integer codigoTeatro) throws Exception {
        verificarCodigoTeatro(codigoTeatro);
        return teatroRepositorio.findById(codigoTeatro).orElse(null);
    }

    /**
     * Metodo que permite registrar una funcion
     *
     * @param funcion
     * @return
     * @throws Exception
     */
    @Override
    public Funcion registrarFuncion(Funcion funcion) throws Exception {
        return null;
    }

    /**
     * Metodo que permite actualizar una funcion
     *
     * @param funcion
     * @return
     * @throws Exception
     */
    @Override
    public Funcion actualizarFuncion(Funcion funcion) throws Exception {
        return null;
    }

    /**
     * Metodo que permite eliminar una funcion
     *
     * @param codigoFuncion
     * @throws Exception
     */
    @Override
    public void eliminarFuncion(Integer codigoFuncion) throws Exception {

    }

    /**
     * Metodo que permite listar las funciones
     *
     * @return
     */
    @Override
    public List<Funcion> listarFunciones() {
        return null;
    }

    /**
     * Metodo que permite consultar una funcion
     *
     * @param codigoFuncion
     * @return
     * @throws Exception
     */
    @Override
    public Funcion consultarFuncion(Integer codigoFuncion) throws Exception {
        return null;
    }

    /**
     * Metodo que permite registrar salas
     *
     * @param sala
     * @return
     * @throws Exception
     */
    @Override
    public Sala registrarSala(Sala sala) throws Exception {
        validarInformacionSala(sala);
        return salaRepositorio.save(sala);
    }

    /**
     * Metodo que permite actualizar una sala
     *
     * @param sala
     * @return
     * @throws Exception
     */
    @Override
    public Sala actualizarSala(Sala sala) throws Exception {
        verificarCodigoSala(sala.getCodigo());
        return salaRepositorio.save(sala);
    }

    /**
     * Metodo que permite eliminar una sala
     *
     * @param codigoSala
     * @throws Exception
     */
    @Override
    public void eliminarSala(Integer codigoSala) throws Exception {
        verificarCodigoSala(codigoSala);
        salaRepositorio.deleteById(codigoSala);
    }

    /**
     * metodo que permite listar las salas
     *
     * @return
     */
    @Override
    public List<Sala> listarSalas() {
        return salaRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar una sala
     *
     * @param codigoSala
     * @return
     * @throws Exception
     */
    @Override
    public Sala consultarSala(Integer codigoSala) throws Exception {
        verificarCodigoSala(codigoSala);
        return salaRepositorio.findById(codigoSala).orElse(null);
    }

    /**
     * Metodo que permite registrar el horario de una funcion
     *
     * @param horarioFuncion
     * @return
     * @throws Exception
     */
    @Override
    public HorarioFuncion registrarHorario(HorarioFuncion horarioFuncion) throws Exception {
        return null;
    }

    /**
     * Metodo que permite actualizar el horario de una funcion
     *
     * @param horarioFuncion
     * @return
     * @throws Exception
     */
    @Override
    public HorarioFuncion actualizarHorario(HorarioFuncion horarioFuncion) throws Exception {
        return null;
    }

    /**
     * Metodo que permite eliminar una funcion
     *
     * @param codigoHorarioFuncion
     * @throws Exception
     */
    @Override
    public void eliminarHorario(Integer codigoHorarioFuncion) throws Exception {

    }

    /**
     * Metodo que permite listar todos los horarios
     *
     * @return
     */
    @Override
    public List<HorarioFuncion> listarHorarios() {
        return null;
    }

    /**
     * Metodo que permite consultar un horario dado su id
     *
     * @param codigoHorarioFuncion
     * @return
     * @throws Exception
     */
    @Override
    public HorarioFuncion consultarHorario(Integer codigoHorarioFuncion) throws Exception {
        return null;
    }

    /**
     * Metodo que permite validar la informacion de un teatro
     * @param teatro
     * @throws Exception
     */
    private void validarInformacionTeatro(Teatro teatro) throws Exception {
        if(teatro.getNombre() == null){
            throw new Exception("El campo nombre es obligatorio");
        } else if(teatro.getDireccion() == null) {
            throw new Exception("El campo direccion es obligatorio");
        } else if(teatro.getTelefono() == null) {
            throw new Exception("El campo telefono es obligatorio");
        }
        Ciudad ciudad = ciudadRepositorio.findById(teatro.getCiudad().getCodigo()).orElse(null);
        if(ciudad == null) {
            throw new Exception("La ciudad debe ser una ciudad valida");
        }
    }

    /**
     * Metodo que permite verificar el codigo de un teatro
     * @param codigoTeatro
     * @throws Exception
     */
    private void verificarCodigoTeatro(Integer codigoTeatro) throws Exception {
        Teatro teatroAlmacenado = teatroRepositorio.findById(codigoTeatro).orElse(null);
        if (teatroAlmacenado == null) {
            throw new Exception("El teatro no existe en el sistema");
        }
    }

    /**
     * Metodo que permite verificar la informacion de una sala
     * @param sala
     * @throws Exception
     */
    private void validarInformacionSala(Sala sala) throws Exception {
        if (sala.getDescripcion() == null) {
            throw new Exception("El campo descripcion es obligatorio");
        } else if (sala.getDistribucion() == null) {
            throw new Exception("El campo distribucion es obligatorio");
        }
        Teatro teatro = teatroRepositorio.findById(sala.getTeatro().getCodigo()).orElse(null);
        if (teatro == null){
            throw new Exception("El teatro es obligatorio");
        }
    }

    /**
     * Metodo para verificar el codigo de la sala
     * @param codigoSala
     * @throws Exception
     */
    private void verificarCodigoSala (Integer codigoSala) throws Exception {
        Sala salaAlmacenada = salaRepositorio.findById(codigoSala).orElse(null);
        if (salaAlmacenada == null){
            throw new Exception("la sala no existe en el sistema");
        }
    }
}
