package com.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import com.banking.service.LoanService;
import com.banking.model.LoanInfo;
import java.util.List;
import java.util.Map;

@RestController
@EnableTransactionManagement

@Controller

public class loanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/saveLoanDetails")
    @CrossOrigin(origins = "http://localhost:4200")
      public ResponseEntity<LoanInfo> saveLoanDetails(@RequestBody LoanInfo loanInfo) {
        LoanInfo loanInfo1 = loanService.saveLoanDetails(loanInfo);
    return ResponseEntity.ok(loanInfo1);
    }

    @GetMapping("/getLoanDetails/{bankId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LoanInfo> getLoanbyBank(@PathVariable("bankId") Long bankId) {
        return loanService.getLoanDetailsByBankId(bankId);
    }
}
