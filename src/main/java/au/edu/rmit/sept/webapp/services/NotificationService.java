package au.edu.rmit.sept.webapp.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.edu.rmit.sept.webapp.exceptions.ResourceNotFoundException;
import au.edu.rmit.sept.webapp.models.Notification;
import au.edu.rmit.sept.webapp.models.Pet;
import au.edu.rmit.sept.webapp.repositories.NotificationRepository;
import au.edu.rmit.sept.webapp.repositories.PetRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private PetRepository petRepository;

    public void createNotification(Notification notification, Long petId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        notification.setPet(pet);
        notificationRepository.save(notification);
    }

    public List<Notification> findByPetId(Long petId) {
        return notificationRepository.findByPetId(petId);
    }
}
