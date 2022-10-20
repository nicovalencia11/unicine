package co.edu.uniquindio.unicine.servicios.servicios;

import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.HorarioFuncion;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Teatro;

import java.util.List;

/**
 * Interface con los metodos abstratos para los administradores de teatro
 */
public interface AdminTeatroServicio {

    /**
     * Metodo que permite registrar el teatro
     * @param teatro
     * @return
     * @throws Exception
     */
    Teatro registrarTeatro(Teatro teatro) throws Exception;

    /**
     * Metodo que permite actualizar un teatro
     * @param teatro
     * @return
     * @throws Exception
     */
    Teatro actualizarTeatro(Teatro teatro) throws Exception;

    /**
     * Metodo que permite permite eliminar un teatro por su id
     * @param codigoTeatro
     * @throws Exception
     */
    void eliminarTeatro(Integer codigoTeatro) throws Exception;

    /**
     * Metodo que permite listar todos los teatros existentes
     * @return
     */
    List<Teatro> listarTeatros();

    /**
     * Metodo que permite consultar un teatro
     * @param codigoTeatro
     * @return
     * @throws Exception
     */
    Teatro consultarTeatro(Integer codigoTeatro) throws Exception;

    /**
     * Metodo que permite registrar una funcion
     * @param funcion
     * @return
     * @throws Exception
     */
    Funcion registrarFuncion(Funcion funcion) throws Exception;

    /**
     * Metodo que permite actualizar una funcion
     * @param funcion
     * @return
     * @throws Exception
     */
    Funcion actualizarFuncion(Funcion funcion) throws Exception;

    /**
     * Metodo que permite eliminar una funcion
     * @param codigoFuncion
     * @throws Exception
     */
    void eliminarFuncion(Integer codigoFuncion) throws Exception;

    /**
     * Metodo que permite listar las funciones
     * @return
     */
    List<Funcion> listarFunciones();

    /**
     * Metodo que permite consultar una funcion
     * @param codigoFuncion
     * @return
     * @throws Exception
     */
    Funcion consultarFuncion(Integer codigoFuncion) throws Exception;

    /**
     * Metodo que permite registrar salas
     * @param sala
     * @return
     * @throws Exception
     */
    Sala registrarSala(Sala sala) throws Exception;

    /**
     * Metodo que permite actualizar una sala
     * @param sala
     * @return
     * @throws Exception
     */
    Sala actualizarSala(Sala sala) throws Exception;

    /**
     * Metodo que permite eliminar una sala
     * @param codigoSala
     * @throws Exception
     */
    void eliminarSala(Integer codigoSala) throws Exception;

    /**
     * metodo que permite listar las salas
     * @return
     */
    List<Sala> listarSalas();

    /**
     * Metodo que permite consultar una sala
     * @param codigoSala
     * @return
     * @throws Exception
     */
    Sala consultarSala(Integer codigoSala) throws Exception;

    /**
     * Metodo que permite registrar el horario de una funcion
     * @param horarioFuncion
     * @return
     * @throws Exception
     */
    HorarioFuncion registrarHorario(HorarioFuncion horarioFuncion) throws Exception;

    /**
     * Metodo que permite actualizar el horario de una funcion
     * @param horarioFuncion
     * @return
     * @throws Exception
     */
    HorarioFuncion actualizarHorario(HorarioFuncion horarioFuncion) throws Exception;

    /**
     * Metodo que permite eliminar una funcion
     * @param codigoHorarioFuncion
     * @throws Exception
     */
    void eliminarHorario(Integer codigoHorarioFuncion) throws Exception;

    /**
     * Metodo que permite listar todos los horarios
     * @return
     */
    List<HorarioFuncion> listarHorarios();

    /**
     * Metodo que permite consultar un horario dado su id
     * @param codigoHorarioFuncion
     * @return
     * @throws Exception
     */
    HorarioFuncion consultarHorario(Integer codigoHorarioFuncion) throws Exception;

}
