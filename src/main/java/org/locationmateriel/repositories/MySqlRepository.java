package org.locationmateriel.repositories;

import org.hibernate.Session;
import org.locationmateriel.utils.SessionHibernate;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MySqlRepository<T> {
    /**
     * Permet de récuperer un records
     * @param id
     * @return
     */
    public T get(int id, Class<T> type) {
        Session session = SessionHibernate.currentSession();
        return session.get(type, id);
    }
    /**
     * Permet de persister un records
     * @param {T} object
     */
    public void save(T object) {
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
    /**
     * Permet de récuperer une liste de records
     * @return
     */
    public List<T> getAll(Class<T> type) {
        Session session = SessionHibernate.currentSession();
        // On récupère le builder pour construire notre requete
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        // On commence a construire la reqest en indiquant la class cible
        CriteriaQuery query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);
        // On continue la construction de la request avec le FROM
        CriteriaQuery<T> all = query.select(root);
        // On récup tte la request
        TypedQuery<T> allQuery = session.createQuery(all);
        // On execute la request
        return allQuery.getResultList();
    }
    /**
     * Permet de supprimer un records
     * @param object
     */
    public void delete(T object) {
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
    /**
     * Permet de mettre à jour un object
     * @param object
     */
    public void update(T object) {
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
}
