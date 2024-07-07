package dev.pehlivan.financeandinvesmentmanagementapplication.controller;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.IncomeDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Income;
import dev.pehlivan.financeandinvesmentmanagementapplication.service.IncomeService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public Income addIncome(@RequestBody IncomeDTO incomeDTO, Authentication authentication) {
        return incomeService.addIncome(authentication.getName(), incomeDTO);
    }

    @GetMapping
    public List<Income> getUserIncomes(Authentication authentication) {
        return incomeService.getUserIncomes(authentication.getName());
    }
}