package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save (Planet planet){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }
    public Planet getById(String id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Planet.class, id);
        }
    }
    public void update(Planet planet){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        }
    }
    public void delete(Planet planet){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.remove(planet);
            tx.commit();
        }
    }
}
