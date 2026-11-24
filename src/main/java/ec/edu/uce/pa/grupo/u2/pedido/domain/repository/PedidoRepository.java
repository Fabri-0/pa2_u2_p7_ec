package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Pedido;

public interface PedidoRepository {

    // Created
    public void create(Pedido pedido);

    //Read por id
    public Optional<Pedido> read(Integer id);

    // Update
    public void update(Pedido pedido);

    //Delete
    public void delete(Integer id);

}
