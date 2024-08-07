package com.banking.service;


import com.banking.entity.CustomerInfoEntity;
import com.banking.repository.CustomerInfoRepository;
import com.banking.model.CustomerInfo;
import com.banking.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    public CustomerInfo saveCustomerDetails(CustomerInfo customerInfo) throws Exception{
        String traceId = "XYZ-89789789";

        CustomerInfoEntity savedcustomerInfoEntity = ConvertUtils.convert(customerInfo);
        //Validation logic
        AtomicInteger i = new AtomicInteger( );
        for (i.set(0); i.get( ) < 10 ; i.getAndIncrement( )) {
            log.info("My message  " + i + "  name is "  + customerInfo.getCustomerName()  + " traceid " + traceId);
        }

        if ( customerInfo.getCustomerName().length() < 10) {
            String x = "Customer name :" + customerInfo.getCustomerName() + " is less than 10 : traceid "+ traceId;
            log.error( x);
            throw new Exception(x);
        }
        CustomerInfoEntity customerInfoEntity = customerInfoRepository.save(savedcustomerInfoEntity);
        CustomerInfo retCustomerInfo = ConvertUtils.convert(customerInfoEntity);
        return retCustomerInfo;
    }

      public List<Map<String,Object>> getAllCustomerInfo(){
        List<CustomerInfoEntity> customerInfoEntityList = customerInfoRepository.findAll();
        return customerInfoEntityList.stream().map(cust->{
            Map<String,Object> map = new HashMap<>();
            map.put("id",cust.getId());
            map.put("accountNum",cust.getAccountId());
            return map;
        }).collect(Collectors.toList());
      }

}
