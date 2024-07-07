package dev.pehlivan.financeandinvesmentmanagementapplication.service;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.NotificationDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.exception.UserNotFoundException;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Notification;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.NotificationRepository;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Notification createNotification(String username, NotificationDTO notificationDTO) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Notification notification = new Notification();
        notification.setMessage(notificationDTO.getMessage());
        notification.setDateTime(notificationDTO.getDateTime());
        notification.setUser(user);
        notification.setRead(notificationDTO.isRead());

        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return notificationRepository.findByUser(user);
    }

    @Transactional
    public void markNotificationAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}