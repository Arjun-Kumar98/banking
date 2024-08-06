package com.banking.service;

import com.banking.entity.BankInfoEntity;
import com.banking.repository.BankInfoRepository;
import com.banking.entity.BankInfoEntity;
import com.banking.model.BankInfo;
import com.banking.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class BankingService {
    private static final Logger logger = LoggerFactory.getLogger(BankingService.class);
    @Autowired
    private BankInfoRepository bankInfoRepository;
   public ResponseEntity<BankInfoEntity> saveBankDetails(BankInfo bankInfo) {
       BankInfoEntity savedBankInfoEntity = ConvertUtils.convert(bankInfo);
       bankInfoRepository.save(savedBankInfoEntity);
       return ResponseEntity.ok().body(savedBankInfoEntity);
   }

   public List<Map<String,Object>> getBankDetails() {
       List<BankInfoEntity> bankdetails = bankInfoRepository.findByActiveIndIsTrue();
       logger.info("The bank details are {}",bankdetails);
      // BankInfo bankInfo = ConvertUtils.convert(bankdetails.get(0));
       return bankdetails.stream().map(bank -> {
           Map<String,Object> map = new HashMap<>();
           map.put("id",bank.getId());
           map.put("name",bank.getBankName());
           return map;
       }).collect(Collectors.toList());

   }
   //public BankingAcknowledgement saveCustomerdetails(BankingRequest bankingRequest) {

   }



