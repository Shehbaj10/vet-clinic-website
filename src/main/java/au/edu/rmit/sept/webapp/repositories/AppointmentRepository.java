package au.edu.rmit.sept.webapp.repositories;

import au.edu.rmit.sept.webapp.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByVetId(Long vetId);
    List<Appointment> findByPetId(Long petId);
}
