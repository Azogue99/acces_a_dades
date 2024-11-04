package models;

import jakarta.persistence.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

@Entity
@Table(name = "llibres")
public class Llibre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titol", nullable = false)
    private String titol;

    @Column(name = "any_publicacio")
    private int anyPublicacio;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    // Constructor per defecte
    public Llibre() {}

    // Constructor amb parametres
    public Llibre(String titol, int anyPublicacio, Autor autor) {
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
        this.autor = autor;
    }

    // Getters i setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    // Metode per guardar el llibre a la base de dades
    public void save() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(this); // Guarda el llibre a la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per actualitzar el llibre
    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(this); // Actualitza el llibre a la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per esborrar el llibre
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(this); // Elimina el llibre de la base de dades
        transaction.commit();
        session.close();
    }

    // Metode static per trobar un llibre per ID
    public static Llibre findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Llibre llibre = session.get(Llibre.class, id); // Obte el llibre per ID
        session.close();
        return llibre;
    }
    
    // Metode static per trobar llibres per autor
    public static List<Llibre> findByAuthor(Autor autor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery("FROM Llibre WHERE autor = :autor", Llibre.class)
                                      .setParameter("autor", autor)
                                      .getResultList(); // Obte els llibres associats a un autor
        session.close();
        return llibres;
    }

    @Override
    public String toString() {
        return "Llibre [id=" + id + ", titol=" + titol + ", anyPublicacio=" + anyPublicacio + "]";
    }
}
