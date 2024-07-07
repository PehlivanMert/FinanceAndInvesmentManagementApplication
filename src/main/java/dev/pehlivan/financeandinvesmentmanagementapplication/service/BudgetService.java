package dev.pehlivan.financeandinvesmentmanagementapplication.service;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.BudgetDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.exception.UserNotFoundException;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Budget;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.BudgetRepository;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public BudgetService(BudgetRepository budgetRepository, UserRepository userRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Budget createBudget(String username, BudgetDTO budgetDTO) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Budget budget = new Budget();
        budget.setCategory(budgetDTO.getCategory());
        budget.setAmount(budgetDTO.getAmount());
        budget.setStartDate(budgetDTO.getStartDate());
        budget.setEndDate(budgetDTO.getEndDate());
        budget.setUser(user);

        return budgetRepository.save(budget);
    }

    public List<Budget> getUserBudgets(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return budgetRepository.findByUser(user);
    }
}