INSERT INTO CLIENT (NAME) values ('Jack'),
                                 ('Vasyl'),
                                 ('Georgiy'),
                                 ('Marcus'),
                                 ('Max'),
                                 ('George'),
                                 ('Mario'),
                                 ('Anton'),
                                 ('Daniel'),
                                 ('Vitaliy');

INSERT INTO PLANET (ID, NAME) values ('MARS','MARS'),
                                     ('VEN','VENUS'),
                                     ('NEP','NEPTUNE'),
                                     ('ERT','EARTH'),
                                     ('MERC','MERCURY');
INSERT INTO TICKET(client_id, from_planet_id, to_planet_id) values
        ( 1,'MARS','VEN' ),
        ( 2,'MARS','ERT' ),
        ( 3,'MARS','VEN' ),
        ( 4,'VEN','NEP' ),
        ( 5,'VEN','NEP' ),
        ( 6,'NEP','ERT' ),
        ( 7,'ERT','MARS' ),
        ( 8,'MERC','NEP' ),
        ( 9,'MERC','MARS' ),
        ( 10,'NEP','ERT' );