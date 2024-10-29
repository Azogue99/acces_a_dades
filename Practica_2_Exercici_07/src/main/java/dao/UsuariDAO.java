
package dao;

import models.Usuari;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class UsuariDAO {

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
}
