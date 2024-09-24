package au.edu.rmit.sept.webapp.controllers;

import au.edu.rmit.sept.webapp.models.Appointment;
import au.edu.rmit.sept.webapp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/schedule")
    public String scheduleAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        // Add lists for pets and vets for dropdowns
        model.addAttribute("pets", petService.findAll());  
        model.addAttribute("vets", vetService.findAll()); 
        return "scheduleAppointment";  // Thymeleaf template
    }

    @PostMapping("/schedule")
    public String scheduleAppointment(@ModelAttribute Appointment appointment, @RequestParam("petId") Long petId, @RequestParam("vetId") Long vetId) {
        appointmentService.scheduleAppointment(appointment, petId, vetId);
        return "redirect:/appointments/list";  // Redirect to the list of appointments
    }
}

