package org.example;

public class TicketCrudUsageExample {
    //homework for module 14
    public static void main(String[] args) {
        FlyWayInterface.fwMigrate();
        TicketCrudService ticketCrud = new TicketCrudService();
        ClientCrudService clientCrud = new ClientCrudService();
        PlanetCrudService planetCrud = new PlanetCrudService();

        //creating ticket instance for test
        Ticket ticket = new Ticket();
        ticket.setClientId(clientCrud.getById(2L));
        ticket.setFromPlanetId(planetCrud.getById("ERT"));
        ticket.setToPlanetId(planetCrud.getById("VEN"));

        ticketCrud.save(ticket);

        HibernateUtil.getInstance().close();
    }
}
