package com.banking;


import com.banking.model.BankInfo;
import com.banking.service.BankingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableTransactionManagement
public class bankController {
//
    @Autowired
    private BankingService bankingService;

    @PostMapping("/saveBankerDetails")
    @CrossOrigin(origins = "http://localhost:4200")
     public ResponseEntity<BankInfo> saveBankDetails(@RequestBody BankInfo bankInfo) {
        bankingService.saveBankDetails(bankInfo);
        return ResponseEntity.ok(bankInfo);
    }
//
//
    @GetMapping("/getBankDetails")
    @CrossOrigin(origins="http://localhost:4200")
    public List<BankInfo> getBankDetails() {
        return bankingService.getBankDetails();
    }

 

}




