package co.edu.uniquindio.unicine.servicios.implementacion;

import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.HorarioFuncion;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.servicios.servicios.AdminTeatroServicio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio con la implementacion de los metodos para el administrador del teatro
 */
@Service
public class AdminTeatroServicioImpl implements AdminTeatroServicio {

    /**
     * Metodo que permite registrar el teatro
     *
     * @param teatro
     * @return
     * @throws Exception
     */
    @Override
    public Teatro registrarTeatro(Teatro teatro) throws Exception {
        return null;
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
        return null;
    }

    /**
     * Metodo que permite permite eliminar un teatro por su id
     *
     * @param codigoTeatro
     * @throws Exception
     */
    @Override
    public void eliminarTeatro(Integer codigoTeatro) throws Exception {

    }

    /**
     * Metodo que permite listar todos los teatros existentes
     *
     * @return
     */
    @Override
    public List<Teatro> listarTeatros() {
        return null;
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
        return null;
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
        return null;
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
        return null;
    }

    /**
     * Metodo que permite eliminar una sala
     *
     * @param codigoSala
     * @throws Exception
     */
    @Override
    public void eliminarSala(Integer codigoSala) throws Exception {

    }

    /**
     * metodo que permite listar las salas
     *
     * @return
     */
    @Override
    public List<Sala> listarSalas() {
        return null;
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
        return null;
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
}
