package au.edu.rmit.sept.webapp.repositories;

import au.edu.rmit.sept.webapp.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByPetId(Long petId);
}

