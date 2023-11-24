package org.example;

public class CrudUsageTest {
    public static void main(String[] args) {
        FlyWayInterface.fwMigrate();
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        Client client = new Client();
        client.setName("Patrick");
        clientService.save(client);

        Client clientFound = clientService.getById(2L);
        System.out.println(clientFound);

        clientFound.setName("Andriy");
        clientService.update(clientFound);

        clientService.delete(client);

        Planet planet = new Planet();
        planet.setId("SAT");
        planet.setName("SATURN");
        planetService.save(planet);

        Planet planetFound = planetService.getById("SAT");
        System.out.println(planetFound);

        planetFound.setName("NotSATURN");
        planetService.update(planetFound);

        planetService.delete(planetFound);

        HibernateUtil.getInstance().close();
    }
}
