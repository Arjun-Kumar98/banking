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

import java.util.*;
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

   public List<BankInfo> getBankDetails() {
       List<BankInfoEntity> bankdetails = bankInfoRepository.findByActiveIndIsTrue();
       List<BankInfo> bankInfoList = new ArrayList<>();
       for(BankInfoEntity bankInfoEntity : bankdetails) {
           bankInfoList.add(ConvertUtils.convert(bankInfoEntity));
       }

   return bankInfoList;
   }
   //public BankingAcknowledgement saveCustomerdetails(BankingRequest bankingRequest) {

   }



