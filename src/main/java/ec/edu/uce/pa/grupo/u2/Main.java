package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;

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

        Pedido pedido = new Pedido();
        pedido.setProducto("Producto prueba");
        pedido.setPrecio(10.0);
        pedido.setFecha(LocalDateTime.now());

        this.pedidoService.guardar(pedido);

        // Prueba de "DetallePedido"
        
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCantidad(23);
        detallePedido.setPrecioUnitario(0.28);
        detallePedido.setDescuento(0.05);
        
        this.detallePedidoService.guardar(detallePedido);

        // Prueba de "Envio"
        Envio envio = new Envio();
        envio.setDireccion("Av. General Enriquez");
        envio.setCiudad("Quito");
        envio.setCodigoPostal("171112");
        envio.setNumeroGuia("GUIA-12345");

        this.envioService.guardar(envio);

        // Prueba de "Pago"
        Pago pago = new Pago();
        pago.setMonto(150.75);
        pago.setMetodoPago("Tarjeta de Crédito");
        pago.setFechaPago("2026-11-23");
        pago.setEstado("Completado");

        this.pagoService.guardar(pago);

        // Prueba de "Producto"
        Producto producto = new Producto();
        producto.setNombre("Play Station 5 PRO");
        producto.setDescripcion("Play Station 5 PRO - 512GB SSD");
        producto.setPrecio(1200.0);
        producto.setStock(10);

        this.productoService.guardar(producto);

        // Prueba de "Cliente"
        Cliente cliente = new Cliente();
        cliente.setNombre("Fabricio");
        cliente.setApellido("Topon");
        cliente.setEmail("fabri@gmail.com");
        cliente.setTelefono("0987654999");

        this.clienteService.guardar(cliente);

        return 0;
    }

}
