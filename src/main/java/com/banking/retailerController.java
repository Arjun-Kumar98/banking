package com.banking;

import com.banking.model.RetailerInfo;
import com.banking.service.RetailerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableTransactionManagement

@Controller

public class retailerController {

    @Autowired
    private RetailerService retailerService;

    @PostMapping("/saveRetailerDetails")
    @CrossOrigin(origins = "http://localhost:4200")
    public RetailerInfo saveRetailerDetails(@RequestBody RetailerInfo retailerInfo) {
        return retailerService.saveRetailerDetails(retailerInfo);
    }

    @GetMapping("/getRetailerDetails")
    @CrossOrigin(origins="http://localhost:4200")
    public List<RetailerInfo> getRetailerDetails() {
        return retailerService.getRetailerDetails();

    }
 }
