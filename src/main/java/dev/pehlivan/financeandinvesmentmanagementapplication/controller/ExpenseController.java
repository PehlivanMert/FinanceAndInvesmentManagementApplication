package dev.pehlivan.financeandinvesmentmanagementapplication.controller;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.ExpenseDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Expense;
import dev.pehlivan.financeandinvesmentmanagementapplication.service.ExpenseService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@RequestBody ExpenseDTO expenseDTO, Authentication authentication) {
        return expenseService.addExpense(authentication.getName(), expenseDTO);
    }

    @GetMapping
    public List<Expense> getUserExpenses(Authentication authentication) {
        return expenseService.getUserExpenses(authentication.getName());
    }
}