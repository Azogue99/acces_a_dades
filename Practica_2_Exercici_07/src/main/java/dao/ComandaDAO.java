
package dao;

import models.Comanda;
import models.Usuari;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class ComandaDAO {

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
}
