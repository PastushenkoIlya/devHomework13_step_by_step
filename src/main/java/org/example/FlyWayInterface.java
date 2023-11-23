package org.example;

import org.flywaydb.core.Flyway;

public class FlyWayInterface {
    private FlyWayInterface() {

    }

    public static void fwMigrate(){
        Flyway.configure()
                .dataSource("jdbc:h2:./myDb", "","")
                .schemas("public")
                .load()
                .migrate();
    }
}