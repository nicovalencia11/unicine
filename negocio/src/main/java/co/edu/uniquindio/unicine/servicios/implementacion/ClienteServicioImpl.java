package co.edu.uniquindio.unicine.servicios.implementacion;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.enums.Estado;
import co.edu.uniquindio.unicine.repositorios.*;
import co.edu.uniquindio.unicine.servicios.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase con la implementacion de los metodos de un cliente
 */
@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private CiudadRepositorio ciudadRepositorio;
    @Autowired
    private TeatroRepositorio teatroRepositorio;
    @Autowired
    private FuncionRepositorio funcionRepositorio;
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    @Autowired
    private HorarioFuncionRepositorio horarioFuncionRepositorio;
    @Autowired
    private VentaRepositorio ventaRepositorio;
    @Autowired
    private CuponRepositorio cuponRepositorio;
    @Autowired
    private ConfiteriaRepositorio confiteriaRepositorio;

    /**
     * Metodo que permite registrar un cliente
     *
     * @param cliente
     * @return
     * @throws Exception
     */
    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        if(verificarCorreoCedula(cliente.getCorreo(), cliente.getCedula())){
            throw new Exception("El correo o la cedula ya se encuentran registrados");
        }
        return clienteRepositorio.save(cliente);
    }

    /**
     * Metodo que permite actualizar un cliente
     *
     * @param cliente
     * @return
     * @throws Exception
     */
    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        verificarCodigo(cliente.getCodigo());
        return clienteRepositorio.save(cliente);
    }

    /**
     * Metodo que permite eliminar un cliente
     *
     * @param codigoCliente
     * @throws Exception
     */
    @Override
    public void eliminarCliente(Integer codigoCliente) throws Exception {
        verificarCodigo(codigoCliente);
        clienteRepositorio.deleteById(codigoCliente);
    }

    /**
     * Metodo que permite listar los cliente
     *
     * @return
     */
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    /**
     * Metodo que permite consultar un lciente por su codigo
     *
     * @param codigoCliente
     * @return
     * @throws Exception
     */
    @Override
    public Cliente consultarCliente(Integer codigoCliente) throws Exception {
        verificarCodigo(codigoCliente);
        return clienteRepositorio.findById(codigoCliente).orElse(null);
    }

    /**
     * Metodo que permite listar las ciudades
     *
     * @return
     */
    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepositorio.findAll();
    }

    /**
     * Metodo que permite listar los teatros dado el codigo de una ciudad
     *
     * @param codigoCiudad
     * @return
     */
    @Override
    public List<Teatro> listarTeatrosCiudad(Integer codigoCiudad)  throws Exception {
        Ciudad ciudad = ciudadRepositorio.findById(codigoCiudad).orElse(null);
        if(ciudad == null){
            throw new Exception("La ciudad no existe en el sistema");
        }
        return teatroRepositorio.listarTeatrosByCiudad(codigoCiudad);
    }

    /**
     * Metodo que permite listar las peliculas en cartelera de un teatro
     *
     * @param codigoTeatro
     * @return
     */
    @Override
    public List<Pelicula> listarPeliculasCartelera(Integer codigoTeatro)  throws Exception {
        Teatro teatro = teatroRepositorio.findById(codigoTeatro).orElse(null);
        if(teatro == null){
            throw new Exception("El teatro no existe en el sistema");
        }
        return funcionRepositorio.listarPeliculasCartelera(codigoTeatro, Estado.CARTELERA, Estado.PREVENTA);
    }

    /**
     * Metodo que permite listar las funciones de una pelicula
     * en un teatro especifico
     *
     * @param codigoPelicula
     * @param codigoTeatro
     * @return
     */
    @Override
    public List<Funcion> listarFuncionesPelicula(Integer codigoPelicula, Integer codigoTeatro) throws Exception {
        Pelicula pelicula = peliculaRepositorio.findById(codigoPelicula).orElse(null);
        Teatro teatro = teatroRepositorio.findById(codigoTeatro).orElse(null);
        if(pelicula == null || teatro == null){
            throw new Exception("La pelicula o el teatro no existen en el sistema");
        }
        return funcionRepositorio.listarFuncionesPeliculaTeatro(codigoPelicula,codigoTeatro);
    }

    /**
     * Metodo que permite registrar una venta
     *
     * @param venta
     * @return
     * @throws Exception
     */
    @Override
    public Venta registrarVenta(Venta venta) throws Exception {
        validarInformacionVenta(venta);
        return ventaRepositorio.save(venta);
    }

    /**
     * Metodo que permite aplicar un cupon a la venta
     *
     * @param cupon
     * @return
     * @throws Exception
     */
    @Override
    public Venta aplicarDescuentoCupon(Venta venta, Cupon cupon) throws Exception {
        Cupon cuponAlmacenado = cuponRepositorio.findById(cupon.getCodigo()).orElse(null);
        if(cuponAlmacenado == null){
            throw new Exception("El cupon no existe en el sistema");
        }
        venta.setCupon(cuponAlmacenado);
        venta.setValorTotal(venta.getValorTotal() - (venta.getValorTotal() * cupon.getDescuento()));
        return venta;
    }

    /**
     * Metodo que permite listar las ventas dado el id de un cliente
     *
     * @param codigoCliente
     * @return
     */
    @Override
    public List<Venta> listarVentas(Integer codigoCliente) {
        return ventaRepositorio.ventasCliente(codigoCliente);
    }

    /**
     * Metodo que permite calificar una pelicula por el cliente
     *
     * @param calificacion
     * @return
     * @throws Exception
     */
    @Override
    public Pelicula calificarPelicula(Pelicula pelicula, Integer calificacion) throws Exception {
        if (calificacion < 0 || calificacion > 5){
            throw new Exception("La calificacion debe ser un numero entre 0 y 5");
        }
        Pelicula peliculaAlmacenada = peliculaRepositorio.findById(pelicula.getCodigo()).orElse(null);
        if (peliculaAlmacenada == null) {
            throw new Exception("La pelicula no existe en el sistema");
        }
        peliculaAlmacenada.setCalificacion(peliculaAlmacenada.getCalificacion() + calificacion);
        peliculaAlmacenada.setCalificadores(peliculaAlmacenada.getCalificadores() + 1);
        return peliculaRepositorio.save(peliculaAlmacenada);
    }

    /**
     * Metodo que permite calificar una confiteria por el cliente
     *
     * @param calificacion
     * @return
     * @throws Exception
     */
    @Override
    public Confiteria calificarConfiteria(Confiteria confiteria, Integer calificacion) throws Exception {
        if (calificacion < 0 || calificacion > 5){
            throw new Exception("La calificacion debe ser un numero entre 0 y 5");
        }
        Confiteria confiteriaAlmacenada = confiteriaRepositorio.findById(confiteria.getCodigo()).orElse(null);
        if (confiteriaAlmacenada == null) {
            throw new Exception("La confiteria no existe en el sistema");
        }
        confiteriaAlmacenada.setCalificacion(confiteriaAlmacenada.getCalificacion() + calificacion);
        confiteriaAlmacenada.setCalificadores(confiteriaAlmacenada.getCalificadores() + 1);
        return confiteriaRepositorio.save(confiteriaAlmacenada);
    }

    /**
     * Metodo que permite verificar si un correo ya existe en la base de datos
     * @param correo
     * @return
     */
    private boolean verificarCorreoCedula(String correo, String cedula) {
        Cliente cliente = clienteRepositorio.findByCorreoAndCedula(correo, cedula);
        if(cliente == null){
            return false;
        }
        return true;
    }

    /**
     * Metodo que permite verificar si un cliente existe por su codigo
     * @param codigoCliente
     * @throws Exception
     */
    private void verificarCodigo(Integer codigoCliente) throws Exception {
        Cliente clienteGuardado = clienteRepositorio.findById(codigoCliente).orElse(null);
        if (clienteGuardado == null){
            throw new Exception("El Cliente no existe en el sistema");
        }
    }

    /**
     * Metodo que permite validar la informacion de una venta
     * @param venta
     * @throws Exception
     */
    private void validarInformacionVenta(Venta venta) throws Exception {
        //Se validan los campos de la venta
        if (venta.getFecha() == null) {
            throw new Exception("El campo fecha es obligatorio");
        } else if(venta.getMedioPago() == null){
            throw new Exception("El campo medio de pago es obligatorio");
        } else if(venta.getValorTotal() == 0){
            throw new Exception("El valor total es obligatorio");
        }
        //Se valida el cliente
        Cliente cliente = clienteRepositorio.findById(venta.getCliente().getCodigo()).orElse(null);
        if(cliente == null){
            throw new Exception("El cliente es obligatorio");
        }
        //Se valida el horario de la funcion
        HorarioFuncion horarioFuncion = horarioFuncionRepositorio.findById(venta.getHorarioFuncion().getCodigo()).orElse(null);
        if(horarioFuncion == null){
            throw new Exception("El horario de la funcion es obligatorio");
        }
    }

}
