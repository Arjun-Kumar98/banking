package com.banking.service;

import com.banking.entity.RetailerInfoEntity;
import com.banking.repository.RetailerInfoRepository;
import com.banking.model.RetailerInfo;
import com.banking.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
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
     public List<RetailerInfo> getRetailerDetails() {
         List<RetailerInfoEntity> retailerInfoEntityList = retailerInfoRepository.findByActiveIndIsTrue();
         List<RetailerInfo> retailerInfoList = new ArrayList<>();
         for(RetailerInfoEntity retailerInfoEntity : retailerInfoEntityList) {
             retailerInfoList.add(ConvertUtils.convert(retailerInfoEntity));
         }
         return retailerInfoList;

     }

}
