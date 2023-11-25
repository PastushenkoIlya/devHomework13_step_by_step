package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Ticket ticket){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            if(isValidTicket(ticket)) session.persist(ticket);
            tx.commit();

        }
    }
    public Ticket getById(Long id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Ticket.class, id);
        }
    }
    public void update(Ticket ticket){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            if(isValidTicket(ticket))session.merge(ticket);
            tx.commit();
        }
    }
    public void delete(Ticket ticket){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.remove(ticket);
            tx.commit();
        }
    }
    private static boolean isValidTicket(Ticket ticket){
        //verifying client_id
        if(ticket.getClientId() == null) return false;
        long clientId = ticket.getClientId().getId();
        ClientCrudService clientCrud = new ClientCrudService();
        if(clientCrud.getById(clientId) == null) return false;
        //verifying from_planet_id
        if(ticket.getFromPlanetId().getId() == null) return false;
        String fromPlanetId = ticket.getFromPlanetId().getId();
        PlanetCrudService planetCrud = new PlanetCrudService();
        if(planetCrud.getById(fromPlanetId) == null) return false;
        //verifying to_planet_id
        if(ticket.getToPlanetId().getId() == null) return false;
        String toPlanetId = ticket.getToPlanetId().getId();
        if(planetCrud.getById(toPlanetId) == null) return false;

        return true;
    }
}
