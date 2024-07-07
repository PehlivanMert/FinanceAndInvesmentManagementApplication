package dev.pehlivan.financeandinvesmentmanagementapplication.repository;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.Notification;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(User user);
}