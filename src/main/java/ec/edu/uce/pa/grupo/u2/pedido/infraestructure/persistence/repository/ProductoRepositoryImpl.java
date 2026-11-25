package ec.edu.uce.pa.grupo.u2.pedido.infraestructure.persistence.repository;

import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedido.domain.model.Producto;
import ec.edu.uce.pa.grupo.u2.pedido.domain.repository.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ProductoRepositoryImpl implements ProductoRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void create(Producto producto) {
        this.entityManager.persist(producto);
    }

    @Override
    public Optional<Producto> read(Integer id) {
        Producto producto = this.entityManager.find(Producto.class, id);
        return Optional.ofNullable(producto);
    }

    @Override
    public void update(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void delete(Integer id) {
        Optional<Producto> producto = this.read(id);
        producto.ifPresent(this.entityManager::remove);
    }

}
