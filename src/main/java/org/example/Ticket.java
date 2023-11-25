package org.example;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name= "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private Instant createdOn;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client_id ;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet from_planet_id;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet to_planet_id;
}
