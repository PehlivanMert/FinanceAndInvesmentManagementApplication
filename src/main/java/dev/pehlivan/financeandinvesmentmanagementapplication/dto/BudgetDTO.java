package dev.pehlivan.financeandinvesmentmanagementapplication.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BudgetDTO {
    private String category;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;
}