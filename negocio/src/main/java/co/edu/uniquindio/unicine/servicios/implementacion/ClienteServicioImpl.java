package co.edu.uniquindio.unicine.servicios.implementacion;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
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

}
