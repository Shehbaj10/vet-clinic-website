package au.edu.rmit.sept.webapp.repositories;

import au.edu.rmit.sept.webapp.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    List<Vet> findBySpecialization(String specialization);
}
