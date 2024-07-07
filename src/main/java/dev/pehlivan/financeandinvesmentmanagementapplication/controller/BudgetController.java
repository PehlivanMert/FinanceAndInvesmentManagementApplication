package dev.pehlivan.financeandinvesmentmanagementapplication.controller;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.BudgetDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Budget;
import dev.pehlivan.financeandinvesmentmanagementapplication.service.BudgetService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/budgets")
    public class BudgetController {
        private final BudgetService budgetService;

        public BudgetController(BudgetService budgetService) {
            this.budgetService = budgetService;
        }

        @PostMapping
        public Budget createBudget(@RequestBody BudgetDTO budgetDTO, Authentication authentication) {
            return budgetService.createBudget(authentication.getName(), budgetDTO);
        }

        @GetMapping
        public List<Budget> getUserBudgets(Authentication authentication) {
            return budgetService.getUserBudgets(authentication.getName());
        }
    }