
package ec.edu.uce.pa.grupo.u2.pedido.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "detalles_pedido") 
public class DetallePedido {

    @Id 
    @SequenceGenerator(name = "detalle_pedido_seq", sequenceName = "detp_seq_db", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_pedido_seq")
    @Column(name = "detp_id") 
    private Integer id;

    @Column(name = "detp_cantidad") 
    private Integer cantidad;

    @Column(name = "detp_precio_unitario") 
    private Double precioUnitario;

    @Column(name = "detp_descuento") 
    private Double descuento;

    @Column(name = "detp_subtotal") 
    private Double subtotal;

    // GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetallePedido [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
                + ", descuento=" + descuento + ", subtotal=" + subtotal + "]";
    }
}
