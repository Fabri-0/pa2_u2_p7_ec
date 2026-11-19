
package ec.edu.uce.pa.grupo.u2.pedido.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "pagos") 
public class Pago {

    @Id 
    @SequenceGenerator(name = "pago_seq", sequenceName = "pago_seq_db", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pago_seq")
    @Column(name = "pago_id") 
    private Integer id;

    @Column(name = "pago_monto") 
    private Double monto;

    @Column(name = "pago_metodo_pago") 
    private String metodoPago;

    @Column(name = "pago_fecha_pago") 
    private String fechaPago;

    @Column(name = "pago_estado") 
    private String estado;

    // GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
