package au.edu.rmit.sept.webapp.services;

import au.edu.rmit.sept.webapp.exceptions.ResourceNotFoundException;
import au.edu.rmit.sept.webapp.models.Appointment;
import au.edu.rmit.sept.webapp.models.Pet;
import au.edu.rmit.sept.webapp.models.Vet;

import au.edu.rmit.sept.webapp.repositories.AppointmentRepository;
import au.edu.rmit.sept.webapp.repositories.PetRepository;
import au.edu.rmit.sept.webapp.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import au.edu.rmit.sept.webapp.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private PetRepository petRepository;
    
    @Autowired
    private VetRepository vetRepository;

    public void scheduleAppointment(Appointment appointment, Long petId, Long vetId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        Vet vet = vetRepository.findById(vetId).orElseThrow(() -> new ResourceNotFoundException("Vet not found"));
        appointment.setVet(pet);
        appointment.setVet(vet);
        appointmentRepository.save(appointment);
    }
}
