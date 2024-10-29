
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "comandes")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuari", nullable = false)
    private Usuari usuari;

    @Column(name = "producte", nullable = false)
    private String producte;

    @Column(name = "preu", nullable = false)
    private BigDecimal preu;

    @Column(name = "data", nullable = false)
    private Timestamp data;

    public Comanda() {}

    public Comanda(Usuari usuari, String producte, BigDecimal preu, Timestamp data) {
        this.usuari = usuari;
        this.producte = producte;
        this.preu = preu;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public String getProducte() {
        return producte;
    }

    public BigDecimal getPreu() {
        return preu;
    }

    public Timestamp getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Comanda [id=" + id + ", producte=" + producte + ", preu=" + preu + ", data=" + data + "]";
    }
}
