package dev.pehlivan.financeandinvesmentmanagementapplication.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InvestmentDTO {
    private String type;
    private double amount;
    private LocalDate date;
}