package com.banking.service;


import com.banking.entity.CustomerInfoEntity;
import com.banking.repository.CustomerInfoRepository;
import com.banking.model.CustomerInfo;
import com.banking.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    public ResponseEntity<CustomerInfoEntity> saveCustomerDetails(CustomerInfo customerInfo) {
        CustomerInfoEntity savedcustomerInfoEntity = ConvertUtils.convert(customerInfo);
        customerInfoRepository.save(savedcustomerInfoEntity);
        return ResponseEntity.ok().body(savedcustomerInfoEntity);
    }

}
