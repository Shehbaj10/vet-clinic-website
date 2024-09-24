package au.edu.rmit.sept.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/create")
    public String createPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "createPet"; // Thymeleaf template for the form
    }

    @PostMapping("/create")
    public String createPet(@ModelAttribute Pet pet, @RequestParam("ownerId") Long ownerId) {
        petService.createPet(pet, ownerId);
        return "redirect:/pets/list"; // Redirect to the list of pets after creation
    }
}

