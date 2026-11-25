package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.application.ClienteService;
import ec.edu.uce.pa.grupo.u2.pedido.application.DetallePedidoService;
import ec.edu.uce.pa.grupo.u2.pedido.application.EnvioService;
import ec.edu.uce.pa.grupo.u2.pedido.application.PagoService;
import ec.edu.uce.pa.grupo.u2.pedido.application.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedido.application.ProductoService;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.DetallePedido;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Envio;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Pago;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Producto;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    @Inject
    private DetallePedidoService detallePedidoService;

    @Inject
    private EnvioService envioService;

    @Inject
    private PagoService pagoService;

    @Inject
    private ProductoService productoService;

    @Inject
    private ClienteService clienteService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {

        /*
        // Prueba de Pedido
        Pedido pedido = new Pedido();
        pedido.setNumero("PED-0001");
        pedido.setFecha(LocalDateTime.now());
        pedido.setPrecio(150.00);
        pedido.setProducto("Laptop");

        this.pedidoService.guardar(pedido);

        // READ (buscar)
        Optional<Pedido> pedido1 = this.pedidoService.buscarPorId(100);

        if (pedido1.isPresent()) {
            System.out.println("Pedido encontrado: " + pedido1.get());
        } else {
            System.out.println("Pedido no encontrado");
        }

        // READ By Number
        Optional<Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("PED-0001");

        if (pedidoByNumber.isPresent()) {
            System.out.println("Pedido encontrado por número: " + pedidoByNumber.get());
        } else {
            System.out.println("Pedido no encontrado por número");
        }
        */

        // Prueba de "Cliente"
        // CREATE
        Cliente cliente = new Cliente();
        cliente.setNombre("Fabricio");
        cliente.setApellido("Topon");
        cliente.setEmail("fabri@gmail.com");
        cliente.setTelefono("0987654999");

        this.clienteService.guardar(cliente);

        // READ (buscar)
        Optional<Cliente> cliente1 = this.clienteService.buscarPorId(cliente.getId());

        if (cliente1.isPresent()) {
            System.out.println("Cliente encontrado: " + cliente1.get());
        } else {
            System.out.println("Cliente no encontrado");
        }

        // UPDATE (actualizar)
        System.out.println("Valor anterior");
        cliente.setTelefono("0984512367");
        this.clienteService.actualizar(cliente);

        Optional<Cliente> cliente2 = this.clienteService.buscarPorId(cliente.getId());

        if (cliente2.isPresent()) {
            System.out.println("Cliente actualizado: " + cliente2.get());
        }

        // DELETE (eliminar)
        this.clienteService.eliminar(cliente.getId());

        /*
        // Prueba de "DetallePedido"
        // CREATE
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCantidad(5);
        detallePedido.setPrecioUnitario(12.50);
        detallePedido.setDescuento(2.50);
        detallePedido.setSubtotal(60.00);

        this.detallePedidoService.guardar(detallePedido);

        // READ (buscar)
        Optional<DetallePedido> detallePedido1 = this.detallePedidoService.buscarPorId(detallePedido.getId());

        if (detallePedido1.isPresent()) {
            System.out.println("DetallePedido encontrado: " + detallePedido1.get());
        } else {
            System.out.println("DetallePedido no encontrado");
        }

        // UPDATE (actualizar)
        System.out.println("Valor anterior");
        detallePedido.setCantidad(8);
        detallePedido.setSubtotal(97.50);
        this.detallePedidoService.actualizar(detallePedido);

        Optional<DetallePedido> detallePedido2 = this.detallePedidoService.buscarPorId(detallePedido.getId());

        if (detallePedido2.isPresent()) {
            System.out.println("DetallePedido actualizado: " + detallePedido2.get());
        }

        // DELETE (eliminar)
        this.detallePedidoService.eliminar(detallePedido.getId());
        */

        /*
        // Prueba de "Envio"
        // CREATE
        Envio envio = new Envio();
        envio.setDireccion("Av. General Enriquez");
        envio.setCiudad("Quito");
        envio.setCodigoPostal("171112");
        envio.setNumeroGuia("GUIA-12345");

        this.envioService.guardar(envio);

        // READ (buscar)
        Optional<Envio> envio1 = this.envioService.buscarPorId(envio.getId());

        if (envio1.isPresent()) {
            System.out.println("Envio encontrado: " + envio1.get());
        } else {
            System.out.println("Envio no encontrado");
        }

        // UPDATE (actualizar)
        System.out.println("Valor anterior");
        envio.setDireccion("Av. Amazonas y Naciones Unidas");
        this.envioService.actualizar(envio);

        Optional<Envio> envio2 = this.envioService.buscarPorId(envio.getId());

        if (envio2.isPresent()) {
            System.out.println("Envio actualizado: " + envio2.get());
        }

        // DELETE (eliminar)
        this.envioService.eliminar(envio.getId());
        */

        /*
        // Prueba de "Pago"
        // CREATE
        Pago pago = new Pago();
        pago.setMonto(150.75);
        pago.setMetodoPago("Tarjeta de Crédito");
        pago.setFechaPago("2026-11-23");
        pago.setEstado("Pendiente");

        this.pagoService.guardar(pago);

        // READ (buscar)
        Optional<Pago> pago1 = this.pagoService.buscarPorId(pago.getId());

        if (pago1.isPresent()) {
            System.out.println("Pago encontrado: " + pago1.get());
        } else {
            System.out.println("Pago no encontrado");
        }

        // UPDATE (actualizar)
        System.out.println("Valor anterior");
        pago.setEstado("Completado");
        this.pagoService.actualizar(pago);

        Optional<Pago> pago2 = this.pagoService.buscarPorId(pago.getId());

        if (pago2.isPresent()) {
            System.out.println("Pago actualizado: " + pago2.get());
        }

        // DELETE (eliminar)
        this.pagoService.eliminar(pago.getId());
        */

        /*
        // Prueba de "Producto"
        // CREATE
        Producto producto = new Producto();
        producto.setNombre("Play Station 5 PRO");
        producto.setDescripcion("Play Station 5 PRO - 512GB SSD");
        producto.setPrecio(1200.0);
        producto.setStock(10);

        this.productoService.guardar(producto);

        // READ (buscar)
        Optional<Producto> producto1 = this.productoService.buscarPorId(producto.getId());

        if (producto1.isPresent()) {
            System.out.println("Producto encontrado: " + producto1.get());
        } else {
            System.out.println("Producto no encontrado");
        }

        // UPDATE (actualizar)
        System.out.println("Valor anterior");
        producto.setPrecio(1150.0);
        this.productoService.actualizar(producto);

        Optional<Producto> producto2 = this.productoService.buscarPorId(producto.getId());

        if (producto2.isPresent()) {
            System.out.println("Producto actualizado: " + producto2.get());
        }

        // DELETE (eliminar)
        this.productoService.eliminar(producto.getId());
        */

        return 0;
    }

}
