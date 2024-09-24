package au.edu.rmit.sept.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/medicalrecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/view/{petId}")
    public String viewMedicalRecords(@PathVariable Long petId, Model model) {
        model.addAttribute("medicalRecords", medicalRecordService.findByPetId(petId));
        return "viewMedicalRecords";  // Thymeleaf template
    }

    @GetMapping("/download/{petId}")
    public ResponseEntity<Resource> downloadMedicalRecords(@PathVariable Long petId) {
        String content = medicalRecordService.generateMedicalRecordPDF(petId);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(content.getBytes()));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=medical_records.pdf")
                .body(resource);
    }
}

