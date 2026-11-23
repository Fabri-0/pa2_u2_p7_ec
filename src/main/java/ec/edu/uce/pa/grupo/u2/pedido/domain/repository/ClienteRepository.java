package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Cliente;

public interface ClienteRepository {

    public void create(Cliente cliente);

    public Cliente read(Integer id);

    public void update(Cliente cliente);

    public void delete(Integer id);

}
