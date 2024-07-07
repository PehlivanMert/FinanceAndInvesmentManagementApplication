package dev.pehlivan.financeandinvesmentmanagementapplication.service;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.InvestmentDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.exception.UserNotFoundException;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Investment;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.User;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.InvestmentRepository;
import dev.pehlivan.financeandinvesmentmanagementapplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvestmentService {
    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;

    public InvestmentService(InvestmentRepository investmentRepository, UserRepository userRepository) {
        this.investmentRepository = investmentRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Investment addInvestment(String username, InvestmentDTO investmentDTO) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Investment investment = new Investment();
        investment.setType(investmentDTO.getType());
        investment.setAmount(investmentDTO.getAmount());
        investment.setDate(investmentDTO.getDate());
        investment.setUser(user);

        return investmentRepository.save(investment);
    }

    public List<Investment> getUserInvestments(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return investmentRepository.findByUser(user);
    }
}