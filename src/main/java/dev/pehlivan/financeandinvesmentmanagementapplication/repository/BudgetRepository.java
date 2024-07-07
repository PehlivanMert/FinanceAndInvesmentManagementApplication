package dev.pehlivan.financeandinvesmentmanagementapplication.repository;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.Budget;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUser(User user);
}