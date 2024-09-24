package au.edu.rmit.sept.webapp.services;

import au.edu.rmit.sept.webapp.exceptions.ResourceNotFoundException;
import au.edu.rmit.sept.webapp.models.Pet;
import au.edu.rmit.sept.webapp.models.User;
import au.edu.rmit.sept.webapp.repositories.PetRepository;
import au.edu.rmit.sept.webapp.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    
    @Autowired
    private UserRepository userRepository;

    public void createPet(Pet pet, Long ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new ResourceNotFoundException("Owner not found"));
        pet.setOwner(owner);
        petRepository.save(pet);
    }
}
