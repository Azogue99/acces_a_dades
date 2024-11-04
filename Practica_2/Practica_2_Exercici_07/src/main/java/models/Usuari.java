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

    // Constructor per defecte
    public Usuari() {}

    // Constructor amb parametres
    public Usuari(String nom, String correu) {
        this.nom = nom;
        this.correu = correu;
    }

    // Getters i setters
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
    
    // Inserir un nou usuari
    public void saveUsuari(Usuari usuari) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuari); // Guarda l'usuari a la base de dades
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback en cas d'error
            e.printStackTrace();
        }
    }

    // Obtenir tots els usuaris
    public List<Usuari> getAllUsuaris() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Usuari", Usuari.class).list(); // Consulta per obtenir tots els usuaris
        }
    }

    // Actualitzar el correu d'un usuari
    public void updateEmail(int userId, String newEmail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Usuari usuari = session.get(Usuari.class, userId);
            if (usuari != null) {
                usuari.setCorreu(newEmail); // Actualitza el correu de l'usuari
                session.update(usuari);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback en cas d'error
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Usuari [id=" + id + ", nom=" + nom + ", correu=" + correu + "]";
    }
}
