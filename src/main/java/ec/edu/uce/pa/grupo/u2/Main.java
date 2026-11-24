package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.application.ClienteService;
import ec.edu.uce.pa.grupo.u2.pedido.application.DetallePedidoService;
import ec.edu.uce.pa.grupo.u2.pedido.application.EnvioService;
import ec.edu.uce.pa.grupo.u2.pedido.application.PagoService;
import ec.edu.uce.pa.grupo.u2.pedido.application.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedido.application.ProductoService;
import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Pedido;
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

        return 0;
    }

}
