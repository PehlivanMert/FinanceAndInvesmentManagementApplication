package dev.pehlivan.financeandinvesmentmanagementapplication.controller;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.NotificationDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Notification;
import dev.pehlivan.financeandinvesmentmanagementapplication.service.NotificationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification createNotification(@RequestBody NotificationDTO notificationDTO, Authentication authentication) {
        return notificationService.createNotification(authentication.getName(), notificationDTO);
    }

    @GetMapping
    public List<Notification> getUserNotifications(Authentication authentication) {
        return notificationService.getUserNotifications(authentication.getName());
    }

    @PutMapping("/{id}/read")
    public void markNotificationAsRead(@PathVariable Long id) {
        notificationService.markNotificationAsRead(id);
    }
}