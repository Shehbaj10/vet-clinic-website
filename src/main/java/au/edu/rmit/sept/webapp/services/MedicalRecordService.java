package au.edu.rmit.sept.webapp.services;

import au.edu.rmit.sept.webapp.models.Pet;
import au.edu.rmit.sept.webapp.models.MedicalRecord;

import au.edu.rmit.sept.webapp.repositories.MedicalRecordRepository;
import au.edu.rmit.sept.webapp.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    
    @Autowired
    private PetRepository petRepository;

    // Find medical records for a specific pet
    public List<MedicalRecord> findByPetId(Long petId) {
        return medicalRecordRepository.findByPetId(petId);
    }

    // Generate a downloadable PDF of medical records (simplified for example)
    public String generateMedicalRecordPDF(Long petId) {
        Pet pet = petRepository.findById(petId)
                               .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));

        List<MedicalRecord> records = findByPetId(petId);
        StringBuilder recordContent = new StringBuilder();

        recordContent.append("Medical Records for: ").append(pet.getName()).append("\n");
        for (MedicalRecord record : records) {
            recordContent.append("Vaccination History: ").append(record.getVaccinationHistory()).append("\n");
            recordContent.append("Treatments: ").append(record.getTreatments()).append("\n");
            recordContent.append("Allergies: ").append(record.getAllergies()).append("\n\n");
        }

        return recordContent.toString();  // In a real app, this would be a PDF generation logic
    }
}

