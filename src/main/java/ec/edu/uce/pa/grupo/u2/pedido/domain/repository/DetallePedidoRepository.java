package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.DetallePedido;

public interface DetallePedidoRepository {

    // Created
    public void create(DetallePedido detallePedido);

    //Read por id
    public DetallePedido read(Integer id);

    // Update
    public void update(DetallePedido detallePedido);

    //Delete
    public void delete(Integer id);
}
