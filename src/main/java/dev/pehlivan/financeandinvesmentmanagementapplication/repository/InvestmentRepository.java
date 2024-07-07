package dev.pehlivan.financeandinvesmentmanagementapplication.repository;

import dev.pehlivan.financeandinvesmentmanagementapplication.model.Investment;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUser(User user);
}