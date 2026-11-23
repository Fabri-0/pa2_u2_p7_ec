package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Producto;

public interface ProductoRepository {

    public void create(Producto producto);

    public Producto read(Integer id);

    public void update(Producto producto);

    public void delete(Integer id);

}
