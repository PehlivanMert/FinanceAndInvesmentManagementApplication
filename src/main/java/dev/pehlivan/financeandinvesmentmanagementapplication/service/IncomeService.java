package dev.pehlivan.financeandinvesmentmanagementapplication.service;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.IncomeDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.exception.UserNotFoundException;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Income;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.IncomeRepository;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;

    public IncomeService(IncomeRepository incomeRepository, UserRepository userRepository) {
        this.incomeRepository = incomeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Income addIncome(String username, IncomeDTO incomeDTO) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Income income = new Income();
        income.setSource(incomeDTO.getSource());
        income.setAmount(incomeDTO.getAmount());
        income.setDate(incomeDTO.getDate());
        income.setUser(user);

        return incomeRepository.save(income);
    }

    public List<Income> getUserIncomes(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return incomeRepository.findByUser(user);
    }
}