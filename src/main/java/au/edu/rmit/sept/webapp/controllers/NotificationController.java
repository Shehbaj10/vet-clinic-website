package au.edu.rmit.sept.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/setup/{petId}")
    public String setupNotificationForm(@PathVariable Long petId, Model model) {
        model.addAttribute("notification", new Notification());
        model.addAttribute("petId", petId);
        return "setupNotification";  // Thymeleaf template
    }

    @PostMapping("/setup")
    public String setupNotification(@ModelAttribute Notification notification, @RequestParam("petId") Long petId) {
        notificationService.createNotification(notification, petId);
        return "redirect:/notifications/list";  // Redirect to list of notifications
    }
}
