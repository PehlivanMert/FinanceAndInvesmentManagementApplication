package dev.pehlivan.financeandinvesmentmanagementapplication.repository;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.Income;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUser(User user);
}