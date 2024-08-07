package com.banking.service;
import java.util.List;

import com.banking.entity.BankInfoEntity;
import com.banking.entity.CustomerInfoEntity;
import com.banking.entity.RetailerInfoEntity;
import com.banking.repository.BankInfoRepository;
import com.banking.repository.CustomerInfoRepository;
import com.banking.repository.RetailerInfoRepository;
import com.banking.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.banking.entity.LoanInfoEntity;
import com.banking.repository.LoanInfoRepository;
import com.banking.model.LoanInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class LoanService {

    @Autowired
    private LoanInfoRepository loanInfoRepository;

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private BankInfoRepository  bankInfoRepository;

    @Autowired
    private RetailerInfoRepository retailerInfoRepository;


    public LoanInfo saveLoanDetails(LoanInfo loanInfo) {

        //Add validation logic here
        BankInfoEntity bankInfoEntity = bankInfoRepository.getById(loanInfo.getBankId( ));
        CustomerInfoEntity customerInfoEntity = customerInfoRepository.getById(loanInfo.getCustomerId());
        RetailerInfoEntity retailerInfoEntity = retailerInfoRepository.getById(loanInfo.getRetailerId( ));

        //Add validation logic here
        //  chk for bankInfoEntity is not null
        //  chk for customerInfoEntity is not null
        //  chk for retailerInfoEntity is not null
        LoanInfoEntity loanInfoEntity = ConvertUtils.convert(loanInfo,bankInfoEntity,customerInfoEntity,retailerInfoEntity);
        LoanInfoEntity savedloaninfoentity   =  loanInfoRepository.save(loanInfoEntity);
        LoanInfo loanInfo1 = ConvertUtils.convert(savedloaninfoentity);
        return loanInfo1;
    }

}
