package com.banking.service;
import java.util.ArrayList;
import java.util.List;

import com.banking.entity.BankInfoEntity;
import com.banking.entity.CustomerInfoEntity;
import com.banking.entity.RetailerInfoEntity;
import com.banking.repository.BankInfoRepository;
import com.banking.repository.CustomerInfoRepository;
import com.banking.repository.RetailerInfoRepository;
import com.banking.utils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(LoanService.class);
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
       BankInfoEntity bankInfoEntity = bankInfoRepository.getById(loanInfo.getBankId());
       CustomerInfoEntity customerInfoEntity = customerInfoRepository.getById(loanInfo.getCustomerId());
       RetailerInfoEntity retailerInfoEntity = retailerInfoRepository.getById(loanInfo.getRetailerId());

        //Add validation logic here
        //  chk for bankInfoEntity is not null
        //  chk for customerInfoEntity is not null
        //  chk for retailerInfoEntity is not null
        LoanInfoEntity loanInfoEntity = ConvertUtils.convert(loanInfo,bankInfoEntity,retailerInfoEntity,customerInfoEntity);
        LoanInfoEntity savedloaninfoentity   =  loanInfoRepository.save(loanInfoEntity);
        LoanInfo loanInfo1 = ConvertUtils.convert(savedloaninfoentity);
        return loanInfo1;
    }
    public List<LoanInfo> getLoanDetailsByBankId(Long bankId) {
         List<LoanInfoEntity> loanlistentity = loanInfoRepository.findByBankInfoEntityId(bankId);
         List<LoanInfo> loanlist = new ArrayList<LoanInfo>();
         for( LoanInfoEntity lister : loanlistentity){
             loanlist.add(ConvertUtils.convert(lister));
         }
    return loanlist;
    }
    public LoanInfo updateLoanDetails(Long Id,LoanInfo loanInfo){
      //  logger.info("the bank data is == {}",loanInfo.getBankId( ));

        BankInfoEntity bankInfoEntity = bankInfoRepository.getById(loanInfo.getBankId());
        CustomerInfoEntity customerInfoEntity = customerInfoRepository.getById(loanInfo.getCustomerId());
        RetailerInfoEntity retailerInfoEntity = retailerInfoRepository.getById(loanInfo.getRetailerId());
        // Convert DTO to entity
        LoanInfoEntity loanInfoEntity = ConvertUtils.convert(loanInfo ,bankInfoEntity,retailerInfoEntity,customerInfoEntity);


        // Find existing loan by Id and update it
        LoanInfoEntity updatedLoanInfoEntity = loanInfoRepository.findById(Id).map(existingLoan -> {
            existingLoan.setCustomerInfoEntity(customerInfoEntity);
            existingLoan.setBankInfoEntity(bankInfoEntity);
            existingLoan.setRetailerInfoEntity(retailerInfoEntity);
            existingLoan.setCreatedOn(loanInfoEntity.getCreatedOn());
            existingLoan.setUpdatedOn(loanInfoEntity.getUpdatedOn());
            existingLoan.setInvoiceDesc(loanInfoEntity.getInvoiceDesc());
            existingLoan.setInvoiceAmount(loanInfoEntity.getInvoiceAmount());

            // Save the updated entity
            return loanInfoRepository.save(existingLoan);
        }).orElseThrow(() -> new RuntimeException("Loan with ID " + Id + " not found"));

        // Convert the updated entity back to DTO
        return ConvertUtils.convert(updatedLoanInfoEntity);
    }
   public LoanInfo getLoanDetails(Long loanId) {
        LoanInfoEntity loanInfoEntity = loanInfoRepository.getById(loanId);
        LoanInfo loanInfo1 = ConvertUtils.convert(loanInfoEntity);
        return loanInfo1;
   }
}
