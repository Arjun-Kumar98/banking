package com.banking;

import com.banking.model.RetailerInfo;
import com.banking.service.RetailerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement

@Controller

public class retailerController {

    @Autowired
    private RetailerService retailerService;

    @PostMapping("/saveRetailerDetails")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveRetailerDetails(@RequestBody RetailerInfo retailerInfo) {
        retailerService.saveRetailerDetails(retailerInfo);
        return ResponseEntity.ok(retailerInfo);
    }
 }
