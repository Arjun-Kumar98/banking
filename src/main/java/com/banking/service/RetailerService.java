package com.banking.service;

import com.banking.entity.RetailerInfoEntity;
import com.banking.repository.RetailerInfoRepository;
import com.banking.model.RetailerInfo;
import com.banking.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RetailerService {
     private static final Logger logger = LoggerFactory.getLogger(RetailerService.class);

     @Autowired
    private RetailerInfoRepository retailerInfoRepository;

     public ResponseEntity<RetailerInfoEntity> saveRetailerDetails( RetailerInfo retailerInfo) {
         RetailerInfoEntity saveRetailerInfoEntity = ConvertUtils.convert(retailerInfo);
         saveRetailerInfoEntity = retailerInfoRepository.save(saveRetailerInfoEntity);
         return ResponseEntity.ok().body(saveRetailerInfoEntity);
     }
     public List<Map<String, Object>> getRetailerDetails() {
         List<RetailerInfoEntity> retailerInfoEntityList = retailerInfoRepository.findByActiveIndIsTrue();
         return retailerInfoEntityList.stream().map(retailer->{
             Map<String, Object> map = new HashMap<>();
             map.put("id", retailer.getId());
             map.put("name",retailer.getRetailerName());
             return map;
         }).collect(Collectors.toList( ));

     }

}
