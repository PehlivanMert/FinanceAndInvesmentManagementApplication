package dev.pehlivan.financeandinvesmentmanagementapplication.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDTO {
    private String category;
    private double amount;
    private LocalDate date;
}