package dev.pehlivan.financeandinvesmentmanagementapplication.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private String message;
    private LocalDateTime dateTime;
    private boolean read;
}