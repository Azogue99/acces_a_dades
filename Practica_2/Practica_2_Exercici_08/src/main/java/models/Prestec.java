package models;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "prestecs")
public class Prestec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_llibre", nullable = false)
    private Llibre llibre;

    @Column(name = "usuari", nullable = false)
    private String usuari;

    @Column(name = "data_prestec", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPrestec;

    @Column(name = "data_devolucio")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucio;

    // Constructor per defecte
    public Prestec() {}

    // Constructor amb parametres
    public Prestec(Llibre llibre, String usuari, Date dataPrestec, Date dataDevolucio) {
        this.llibre = llibre;
        this.usuari = usuari;
        this.dataPrestec = dataPrestec;
        this.dataDevolucio = dataDevolucio;
    }

    // Getters i setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Llibre getLlibre() {
        return llibre;
    }

    public void setLlibre(Llibre llibre) {
        this.llibre = llibre;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public Date getDataPrestec() {
        return dataPrestec;
    }

    public void setDataPrestec(Date dataPrestec) {
        this.dataPrestec = dataPrestec;
    }

    public Date getDataDevolucio() {
        return dataDevolucio;
    }

    public void setDataDevolucio(Date dataDevolucio) {
        this.dataDevolucio = dataDevolucio;
    }

    // Metode per guardar el prestec a la base de dades
    public void save() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(this); // Guarda el prestec a la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per actualitzar el prestec
    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(this); // Actualitza el prestec a la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per esborrar el prestec
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(this); // Elimina el prestec de la base de dades
        transaction.commit();
        session.close();
    }

    // Metode per trobar un prestec per ID
    public static Prestec findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Prestec prestec = session.get(Prestec.class, id); // Obte el prestec per ID
        session.close();
        return prestec;
    }

    // Metode per trobar prestecs per nom d'usuari
    public static List<Prestec> findByUser(String usuari) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Prestec> prestecs = session.createQuery("FROM Prestec WHERE usuari = :usuari", Prestec.class)
                                        .setParameter("usuari", usuari)
                                        .getResultList(); // Obte els prestecs associats a un usuari
        session.close();
        return prestecs;
    }

    @Override
    public String toString() {
        return "Prestec [id=" + id + ", usuari=" + usuari + ", dataPrestec=" + dataPrestec + ", dataDevolucio=" + dataDevolucio + "]";
    }
}
