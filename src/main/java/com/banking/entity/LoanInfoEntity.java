package com.banking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loan_master")
public class LoanInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

   @Column(name="active_Ind")
    private boolean activeInd;
   @Column(name="invoice_Desc")
    private String invoiceDesc;
   @Column(name = "invoice_Amount")
    private Double invoiceAmount;
  @Column(name = "created_On")
    private LocalDateTime createdOn;
 @Column(name = "updated_On")
    private LocalDateTime updatedOn;
// @Column(name="bank_Id", insertable = false, updatable = false)
// private Long bankId;
// @Column(name="retailer_Id" , insertable = false, updatable = false)
// private Long retailerId;
// @Column(name="customer_Id" , insertable = false, updatable = false)
// private Long customerId;


@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinColumn(name = "bank_Id", referencedColumnName = "Id")
@JsonManagedReference
//private BankInfoEntity bankInfoEntity;
private BankInfoEntity bankInfoEntity;
@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinColumn(name = "retailer_Id", referencedColumnName = "Id")
private RetailerInfoEntity retailerInfoEntity;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "customer_Id", referencedColumnName = "Id")
private CustomerInfoEntity customerInfoEntity;
}
