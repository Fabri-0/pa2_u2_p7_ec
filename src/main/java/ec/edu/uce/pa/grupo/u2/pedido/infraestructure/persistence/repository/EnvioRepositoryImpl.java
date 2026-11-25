package ec.edu.uce.pa.grupo.u2.pedido.infraestructure.persistence.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Envio;
import ec.edu.uce.pa.grupo.u2.pedido.domain.repository.EnvioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class EnvioRepositoryImpl implements EnvioRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Envio envio) {
        this.entityManager.persist(envio);
    }

    @Override
    public Optional<Envio> read(Integer id) {
        Envio envio = this.entityManager.find(Envio.class, id);
        return Optional.ofNullable(envio);
    }

    @Override
    public void update(Envio envio) {
        this.entityManager.merge(envio);
    }

    @Override
    public void delete(Integer id) {
        Optional<Envio> envio = this.read(id);
        envio.ifPresent(this.entityManager::remove);
    }

}
