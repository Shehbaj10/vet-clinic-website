package au.edu.rmit.sept.webapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime appointmentDate;
    private String reason;
    
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
    
    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;

    public void setVet(Vet vet2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVet'");
    }

    public void setVet(Pet pet2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVet'");
    }

    // Getters and setters
}

