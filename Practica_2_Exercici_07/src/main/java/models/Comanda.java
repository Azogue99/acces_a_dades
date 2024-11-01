
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import utils.HibernateUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    
    // Get orders by user ID
    public List<Comanda> getComandesByUsuariId(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Comanda where usuari.id = :userId";
            Query<Comanda> query = session.createQuery(hql, Comanda.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    // Delete order by ID
    public void deleteComanda(int comandaId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Comanda comanda = session.get(Comanda.class, comandaId);
            if (comanda != null) {
                session.delete(comanda);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Comanda [id=" + id + ", producte=" + producte + ", preu=" + preu + ", data=" + data + "]";
    }
}
