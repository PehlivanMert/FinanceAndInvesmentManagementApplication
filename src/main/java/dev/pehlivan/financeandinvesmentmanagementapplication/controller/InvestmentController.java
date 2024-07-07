package dev.pehlivan.financeandinvesmentmanagementapplication.controller;

import dev.pehlivan.financeandinvesmentmanagementapplication.dto.InvestmentDTO;
import dev.pehlivan.financeandinvesmentmanagementapplication.model.Investment;
import dev.pehlivan.financeandinvesmentmanagementapplication.service.InvestmentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public Investment addInvestment(@RequestBody InvestmentDTO investmentDTO, Authentication authentication) {
        return investmentService.addInvestment(authentication.getName(), investmentDTO);
    }

    @GetMapping
    public List<Investment> getUserInvestments(Authentication authentication) {
        return investmentService.getUserInvestments(authentication.getName());
    }
}