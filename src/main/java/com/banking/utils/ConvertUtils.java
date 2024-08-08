package com.banking.utils;

import com.banking.entity.CustomerInfoEntity;
import com.banking.entity.LoanInfoEntity;
import com.banking.entity.RetailerInfoEntity;
import com.banking.model.BankInfo;
import com.banking.entity.BankInfoEntity;

import com.banking.model.CustomerInfo;
import com.banking.model.LoanInfo;
import com.banking.model.RetailerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConvertUtils.class);

public static BankInfoEntity convert(BankInfo bankInfo) {

    BankInfoEntity bankInfoEntity = new BankInfoEntity();
    bankInfoEntity.setId(bankInfo.getId());
    bankInfoEntity.setBankName(bankInfo.getBankName( ));
    bankInfoEntity.setIfscCode(bankInfo.getIfscCode());
    bankInfoEntity.setUpdatedOn(bankInfo.getUpdatedOn());
    bankInfoEntity.setCreatedOn(bankInfo.getCreatedOn());
    bankInfoEntity.setActiveInd(bankInfo.isActiveInd( ));
    return bankInfoEntity;
}

public static BankInfo convert(BankInfoEntity bankInfoEntity) {
    BankInfo bankInfo = new BankInfo( );
  bankInfo.setId(bankInfoEntity.getId( ));
   bankInfo.setBankName(bankInfoEntity.getBankName( ));
   bankInfo.setIfscCode(bankInfoEntity.getIfscCode( ));
   bankInfo.setUpdatedOn(bankInfoEntity.getUpdatedOn( ));
   bankInfo.setCreatedOn(bankInfoEntity.getCreatedOn( ));
   bankInfo.setActiveInd(bankInfoEntity.isActiveInd());
    return bankInfo;
}

public static CustomerInfoEntity  convert( CustomerInfo customerInfo) {

    CustomerInfoEntity customerInfoEntity = new CustomerInfoEntity();
    customerInfoEntity.setId(customerInfo.getId());
    customerInfoEntity.setCustomerName(customerInfo.getCustomerName( ));
    customerInfoEntity.setAccountId(customerInfo.getAccountId());
    customerInfoEntity.setUpdatedOn(customerInfo.getUpdatedOn());
    customerInfoEntity.setCreatedOn(customerInfo.getCreatedOn());
    customerInfoEntity.setActiveInd(customerInfo.isActiveInd());

    return customerInfoEntity;

}
public static CustomerInfo convert(CustomerInfoEntity customerInfoEntity) {
    CustomerInfo customerInfo = new CustomerInfo();
    customerInfo.setId(customerInfoEntity.getId( ));
    customerInfo.setAccountId(customerInfoEntity.getAccountId( ));
    customerInfo.setCustomerName(customerInfoEntity.getCustomerName( ));
    customerInfo.setUpdatedOn(customerInfoEntity.getUpdatedOn());
    customerInfo.setCreatedOn(customerInfoEntity.getCreatedOn());
    customerInfo.setActiveInd(customerInfoEntity.isActiveInd( ));
    //customerInfo.setActiveInd(customerInfoEntity.getActiveInd( ));
    return customerInfo;

}
public static RetailerInfoEntity convert( RetailerInfo retailerInfo) {
    RetailerInfoEntity retailerInfoEntity = new RetailerInfoEntity();
   retailerInfoEntity.setId(retailerInfo.getId());
   retailerInfoEntity.setAccountId(retailerInfo.getAccountId( ));
   retailerInfoEntity.setRetailerName(retailerInfo.getRetailerName( ));
   retailerInfoEntity.setCreatedOn(retailerInfo.getCreatedOn( ));
   retailerInfoEntity.setUpdatedOn(retailerInfo.getUpdatedOn( ));
   retailerInfoEntity.setActiveInd(retailerInfo.isActiveInd( ));
   return retailerInfoEntity;
}
public static RetailerInfo convert(RetailerInfoEntity retailerInfoEntity) {
    RetailerInfo retailerInfo = new RetailerInfo();
    retailerInfo.setId(retailerInfoEntity.getId( ));
    retailerInfo.setAccountId(retailerInfoEntity.getAccountId( ));
    retailerInfo.setRetailerName(retailerInfoEntity.getRetailerName( ));
    retailerInfo.setCreatedOn(retailerInfoEntity.getCreatedOn( ));
    retailerInfo.setUpdatedOn(retailerInfoEntity.getUpdatedOn( ));
    retailerInfo.setActiveInd(retailerInfoEntity.isActiveInd( ));
    return retailerInfo;
}

public static LoanInfoEntity convert(final LoanInfo loanInfo,
                                     final BankInfoEntity bankInfoEntity,
                                     final CustomerInfoEntity customerInfoEntity,
                                     final RetailerInfoEntity retailerInfoEntity) {

    LoanInfoEntity loanInfoEntity = new LoanInfoEntity();

    loanInfoEntity.setBankInfoEntity(bankInfoEntity);
    loanInfoEntity.setCustomerInfoEntity(customerInfoEntity);
    loanInfoEntity.setRetailerInfoEntity(retailerInfoEntity);


    loanInfoEntity.setUpdatedOn(loanInfo.getUpdatedOn( ));
    loanInfoEntity.setCreatedOn(loanInfo.getCreatedOn( ));
    loanInfoEntity.setActiveInd(loanInfo.isActiveInd( ));
    loanInfoEntity.setInvoiceAmount(loanInfo.getInvoiceAmount( ));
    loanInfoEntity.setInvoiceDesc(loanInfo.getInvoiceDesc( ));
    return loanInfoEntity;
}

public static LoanInfo convert(LoanInfoEntity loanInfoEntity) {
    LoanInfo loanInfo = new LoanInfo();
    loanInfo.setId(loanInfoEntity.getId( ));
//    loanInfo.setBankId(loanInfoEntity.getBankId( ));

    loanInfo.setCustomerId(loanInfoEntity.getCustomerInfoEntity( ).getId());
    loanInfo.setRetailerId(loanInfoEntity.getRetailerInfoEntity().getId());
    loanInfo.setBankId(loanInfoEntity.getBankInfoEntity().getId());
    loanInfo.setUpdatedOn(loanInfoEntity.getUpdatedOn( ));
    loanInfo.setCreatedOn(loanInfoEntity.getCreatedOn( ));
    loanInfo.setInvoiceAmount(loanInfoEntity.getInvoiceAmount( ));
    loanInfo.setInvoiceDesc(loanInfoEntity.getInvoiceDesc( ));
    loanInfo.setActiveInd(loanInfoEntity.isActiveInd( ));
    return loanInfo;
}


}
