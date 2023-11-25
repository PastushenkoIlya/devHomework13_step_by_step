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
    @Column(name = "created_at")
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client clientId ;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false, insertable = false, updatable = false)
    private Planet fromPlanetId;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false, insertable = false, updatable = false)
    private Planet toPlanetId;
}
