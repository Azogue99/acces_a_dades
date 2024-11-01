
package models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import utils.HibernateUtil;

@Entity
@Table(name = "usuaris")
public class Usuari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "correu", nullable = false)
    private String correu;

    public Usuari() {}

    public Usuari(String nom, String correu) {
        this.nom = nom;
        this.correu = correu;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }
    
    // Insert new user
    public void saveUsuari(Usuari usuari) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuari);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Get all users
    public List<Usuari> getAllUsuaris() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Usuari", Usuari.class).list();
        }
    }

    // Update user email
    public void updateEmail(int userId, String newEmail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Usuari usuari = session.get(Usuari.class, userId);
            if (usuari != null) {
                usuari.setCorreu(newEmail);
                session.update(usuari);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Usuari [id=" + id + ", nom=" + nom + ", correu=" + correu + "]";
    }
}
