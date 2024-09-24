package au.edu.rmit.sept.webapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private String breed;
    private String age;
    
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;  // Assuming a User class exists

    public void setOwner(User owner2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOwner'");
    }

    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    // Getters and setters
}
