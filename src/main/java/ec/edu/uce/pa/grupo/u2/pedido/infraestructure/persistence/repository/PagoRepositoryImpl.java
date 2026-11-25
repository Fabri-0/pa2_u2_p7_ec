package ec.edu.uce.pa.grupo.u2.pedido.infraestructure.persistence.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Pago;
import ec.edu.uce.pa.grupo.u2.pedido.domain.repository.PagoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PagoRepositoryImpl implements PagoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Pago pago) {
        this.entityManager.persist(pago);
    }

    @Override
    public Optional<Pago> read(Integer id) {
        Pago pago = this.entityManager.find(Pago.class, id);
        return Optional.ofNullable(pago);
    }

    @Override
    public void update(Pago pago) {
        this.entityManager.merge(pago);
    }

    @Override
    public void delete(Integer id) {
        Optional<Pago> pago = this.read(id);
        pago.ifPresent(this.entityManager::remove);
    }

}
