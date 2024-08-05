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

@RestController
@EnableTransactionManagement
public class customerController {
    private static final Logger logger = LoggerFactory.getLogger(customerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomerdetails")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CustomerInfo> addCustomer(@RequestBody CustomerInfo customerInfo) {
        logger.info("the value is == {}", customerInfo);
        customerService.saveCustomerDetails(customerInfo);
        return ResponseEntity.ok(customerInfo);
    }
}
