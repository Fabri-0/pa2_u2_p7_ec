package ec.edu.uce.pa.grupo.u2.pedido.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Envio;

public interface EnvioRepository {

    public void create(Envio envio);

    public Envio read(Integer id);

    public void update(Envio envio);

    public void delete(Integer id);

}
