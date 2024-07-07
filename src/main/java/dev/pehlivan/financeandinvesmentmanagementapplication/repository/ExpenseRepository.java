package dev.pehlivan.financeandinvesmentmanagementapplication.repository;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.Expense;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}