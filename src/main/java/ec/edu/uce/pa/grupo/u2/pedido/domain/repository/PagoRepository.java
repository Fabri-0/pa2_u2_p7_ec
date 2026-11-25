package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Pago;

public interface PagoRepository {

    public void create(Pago pago);

    public Optional<Pago> read(Integer id);

    public void update(Pago pago);

    public void delete(Integer id);

}
