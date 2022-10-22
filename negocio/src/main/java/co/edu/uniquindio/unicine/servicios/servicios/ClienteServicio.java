package co.edu.uniquindio.unicine.servicios.servicios;

import co.edu.uniquindio.unicine.entidades.*;

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

    /**
     * Metodo que permite listar las ciudades
     * @return
     */
    List<Ciudad> listarCiudades();

    /**
     * Metodo que permite listar los teatros dado el codigo de una ciudad
     * @param codigoCiudad
     * @return
     */
    List<Teatro> listarTeatrosCiudad(Integer codigoCiudad) throws Exception;

    /**
     * Metodo que permite listar las peliculas en cartelera de un teatro
     * @param codigoTeatro
     * @return
     */
    List<Pelicula> listarPeliculasCartelera(Integer codigoTeatro) throws Exception;

    /**
     * Metodo que permite listar las funciones de una pelicula dado el teatro y el id de la pelicula
     * @param codigoPelicula
     * @return
     */
    List<Funcion> listarFuncionesPelicula(Integer codigoPelicula, Integer codigoTeatro) throws Exception;

    /**
     * Metodo que permite registrar una venta
     * @param venta
     * @return
     * @throws Exception
     */
    Venta registrarVenta(Venta venta) throws Exception;

    /**
     * Metodo que permite aplicar un cupon a la venta
     * @param cupon
     * @return
     * @throws Exception
     */
    Venta aplicarDescuentoCupon(Cupon cupon) throws Exception;

    /**
     * Metodo que permite listar las ventas dado el id de un cliente
     * @return
     */
    List<Venta> listarVentas(Integer codigoCliente);

}
