package com.bumsoap.controller;

import com.bumsoap.model.Customer;
import com.bumsoap.model.Loans;
import com.bumsoap.repository.CustomerRepository;
import com.bumsoap.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        
        if (optionalCustomer.isPresent()) {
            return loanRepository.findByCustomerIdOrderByStartDtDesc(
                    optionalCustomer.get().getId());
        } else {
            return null;
        }
    }
}
