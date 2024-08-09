package com.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(loanController.class);
    @Autowired
    private LoanService loanService;

    @PostMapping("/saveLoanDetails")
    @CrossOrigin(origins = "http://localhost:4200")
      public ResponseEntity<LoanInfo> saveLoanDetails(@RequestBody LoanInfo loanInfo) {
        LoanInfo loanInfo1 = loanService.saveLoanDetails(loanInfo);
    return ResponseEntity.ok(loanInfo1);
    }

    @GetMapping("/getLoanDetailsbyBank/{bankId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<LoanInfo> getLoanbyBank(@PathVariable("bankId") Long bankId) {
        return loanService.getLoanDetailsByBankId(bankId);
    }
    @GetMapping("/getLoanDetails/{Id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public LoanInfo getLoanDetails(@PathVariable("Id") Long Id) {
        return loanService.getLoanDetails(Id);
    }
    @PutMapping("/updateLoanDetails/{Id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public LoanInfo updateLoanDetails(@PathVariable Long Id, @RequestBody LoanInfo loanInfo) {
      //  logger.info("the loan info is == {}"+loanInfo.toString());
        return loanService.updateLoanDetails(Id,loanInfo);
    }
}
