package co.edu.uniquindio.unicine.servicios.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;

import java.util.List;

/**
 * Interface con los metodos abstratos para el servicio de clientes
 */
public interface ClienteServicio {

    /**
     * Metodo que permite registrar un cliente
     * @param cliente
     * @return
     * @throws Exception
     */
    Cliente registrarCliente(Cliente cliente) throws Exception;

    /**
     * Metodo que permite actualizar un cliente
     * @param cliente
     * @return
     * @throws Exception
     */
    Cliente actualizarCliente(Cliente cliente) throws Exception;

    /**
     * Metodo que permite eliminar un cliente
     * @param codigoCliente
     * @throws Exception
     */
    void eliminarCliente(Integer codigoCliente) throws Exception;

    /**
     * Metodo que permite listar los cliente
     * @return
     */
    List<Cliente> listarClientes();

    /**
     * Metodo que permite consultar un lciente por su codigo
     * @param codigoCliente
     * @return
     * @throws Exception
     */
    Cliente consultarCliente(Integer codigoCliente) throws Exception;

}
