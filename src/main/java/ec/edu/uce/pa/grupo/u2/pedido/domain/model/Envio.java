
package ec.edu.uce.pa.grupo.u2.pedido.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "envios") 
public class Envio {

    @Id 
    @SequenceGenerator(name = "envio_seq", sequenceName = "env_seq_db", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "envio_seq")
    @Column(name = "env_id") 
    private Integer id;

    @Column(name = "env_direccion") 
    private String direccion;

    @Column(name = "env_ciudad") 
    private String ciudad;

    @Column(name = "env_codigo_postal") 
    private String codigoPostal;

    @Column(name = "env_numero_guia") 
    private String numeroGuia;

    // GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }
}
