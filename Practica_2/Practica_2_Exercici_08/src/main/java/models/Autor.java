package models;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

@Entity
@Table(name = "autors")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "nacionalitat")
    private String nacionalitat;

    // Constructor per defecte
    public Autor() {}

    // Constructor amb parametres
    public Autor(String nom, String nacionalitat) {
        this.nom = nom;
        this.nacionalitat = nacionalitat;
    }
    
    // Getters i setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    // Metode per guardar l'autor a la base de dades
    public void save() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(this); // Guarda l'objecte a la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per actualitzar l'autor
    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(this); // Actualitza l'objecte a la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per esborrar l'autor
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(this); // Elimina l'objecte de la base de dades
        transaction.commit();
        session.close();
    }

    // Metode static per trobar un autor per ID
    public static Autor findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Autor autor = session.get(Autor.class, id); // Obte l'objecte per ID
        session.close();
        return autor;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nom=" + nom + ", nacionalitat=" + nacionalitat + "]";
    }
}
