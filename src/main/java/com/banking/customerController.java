package com.banking;


import com.banking.model.CustomerInfo;
import com.banking.service.CustomerService;


import com.banking.utils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class customerController {
    private static final Logger logger = LoggerFactory.getLogger(customerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomerdetails")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CustomerInfo> addCustomer(@RequestBody CustomerInfo customerInfo) throws Exception {

        String traceId ="12347";
        logger.info("inside addCustomer in customer {}", customerInfo);

        CustomerInfo customerInfo1 = customerService.saveCustomerDetails(customerInfo);

        logger.info("return  addCustomer in customer {} traceId : {}", customerInfo1, traceId);
        return ResponseEntity.ok(customerInfo1);
    }

    @GetMapping("/getCustomerDetails")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CustomerInfo> getCustomerDetails() {
        return customerService.getAllCustomerInfo();

    }
}
