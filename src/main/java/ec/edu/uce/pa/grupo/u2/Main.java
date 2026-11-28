package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
import java.util.List;
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


        // Prueba de "Cliente"
        // CREATE
        Cliente cliente = new Cliente();
        cliente.setNombre("Fabricio");
        cliente.setApellido("Topon");
        cliente.setEmail("fabri@gmail.com");
        cliente.setTelefono("0987654999");

        this.clienteService.guardar(cliente);

        // LISTAR TODO
        List<Pedido> pedido = this.pedidoService.listarTodo();
        pedido.forEach(System.out :: println);

        // LISTAR POR NUMERO NATIVE
        Optional<Pedido> pedidoNat = this.pedidoService.buscarPorNumeroNative("PED-0001");
        
        if (pedidoNat.isPresent()) {
            System.out.println("Pedido encontrado: " + pedidoNat.get());
        } else {
            System.out.println("Pedido no encontrado");
        }
        
        // LISTAR TODOS NATIVE
        List<Pedido> listPedidoNat = this.pedidoService.listarTodoNative();
        listPedidoNat.forEach(System.out::println);


       

        

        return 0;
    }

}
