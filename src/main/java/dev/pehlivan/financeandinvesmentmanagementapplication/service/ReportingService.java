package dev.pehlivan.financeandinvesmentmanagementapplication.service;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.*;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingService {
    private final UserRepository userRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final InvestmentRepository investmentRepository;
    private final BudgetRepository budgetRepository;

    public ReportingService(UserRepository userRepository,
                            IncomeRepository incomeRepository,
                            ExpenseRepository expenseRepository,
                            InvestmentRepository investmentRepository,
                            BudgetRepository budgetRepository) {
        this.userRepository = userRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.investmentRepository = investmentRepository;
        this.budgetRepository = budgetRepository;
    }

    public List<Income> getUserIncomes(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return incomeRepository.findByUser(user);
    }

    public List<Expense> getUserExpenses(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return expenseRepository.findByUser(user);
    }

    public List<Investment> getUserInvestments(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return investmentRepository.findByUser(user);
    }

    public List<Budget> getUserBudgets(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return budgetRepository.findByUser(user);
    }
}