package com.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoanInfo {
    private Long Id;
   private Long customerId;
   private Long bankId;
   private Long retailerId;
   private LocalDateTime createdOn;
   private LocalDateTime updatedOn;
   private boolean activeInd;
   private String invoiceDesc;
   private double invoiceAmount;
}
