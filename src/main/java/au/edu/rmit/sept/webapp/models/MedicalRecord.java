package au.edu.rmit.sept.webapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vaccinationHistory;
    private String treatments;
    private String allergies;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    public Object getVaccinationHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVaccinationHistory'");
    }

    public Object getTreatments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTreatments'");
    }

    public Object getAllergies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllergies'");
    }

    // Getters and setters
}

