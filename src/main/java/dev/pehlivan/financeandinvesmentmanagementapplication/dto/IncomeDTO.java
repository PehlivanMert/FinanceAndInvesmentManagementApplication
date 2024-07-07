package dev.pehlivan.financeandinvesmentmanagementapplication.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeDTO {
    private String source;
    private double amount;
    private LocalDate date;
}