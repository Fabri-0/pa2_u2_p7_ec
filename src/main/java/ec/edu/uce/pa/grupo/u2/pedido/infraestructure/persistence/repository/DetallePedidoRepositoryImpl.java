package ec.edu.uce.pa.grupo.u2.pedido.infraestructure.persistence.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.DetallePedido;
import ec.edu.uce.pa.grupo.u2.pedido.domain.repository.DetallePedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped 
public class DetallePedidoRepositoryImpl implements DetallePedidoRepository {

    @Inject 
    private EntityManager entityManager;

    @Override
    public void create(DetallePedido detallePedido) {
        this.entityManager.persist(detallePedido);
    }

    @Override
    public Optional<DetallePedido> read(Integer id) {
        DetallePedido detallePedido = this.entityManager.find(DetallePedido.class, id);
        return Optional.ofNullable(detallePedido);
    }

    @Override
    public void update(DetallePedido detallePedido) {
        this.entityManager.merge(detallePedido);
    }

    @Override
    public void delete(Integer id) {
        Optional<DetallePedido> detallePedido = this.read(id);
        detallePedido.ifPresent(this.entityManager::remove);
    }

}
