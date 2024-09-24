package au.edu.rmit.sept.webapp.repositories;

import au.edu.rmit.sept.webapp.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPetId(Long petId);
}
