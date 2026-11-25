package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Cliente;

public interface ClienteRepository {

    public void create(Cliente cliente);

    public Optional<Cliente> read(Integer id);

    public void update(Cliente cliente);

    public void delete(Integer id);

}
