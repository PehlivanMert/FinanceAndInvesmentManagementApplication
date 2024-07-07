package dev.pehlivan.financeandinvesmentmanagementapplication.controller;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.Budget;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Expense;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Income;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Investment;
import dev.pehlivan.financeandinvesmentmanagementapplication.service.ReportingService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reporting")
public class ReportingController {
    private final ReportingService reportingService;

    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @GetMapping("/incomes")
    public List<Income> getUserIncomes(Authentication authentication) {
        return reportingService.getUserIncomes(authentication.getName());
    }

    @GetMapping("/expenses")
    public List<Expense> getUserExpenses(Authentication authentication) {
        return reportingService.getUserExpenses(authentication.getName());
    }

    @GetMapping("/investments")
    public List<Investment> getUserInvestments(Authentication authentication) {
        return reportingService.getUserInvestments(authentication.getName());
    }

    @GetMapping("/budgets")
    public List<Budget> getUserBudgets(Authentication authentication) {
        return reportingService.getUserBudgets(authentication.getName());
    }
}