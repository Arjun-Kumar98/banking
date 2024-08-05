package com.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "retailer")

public class RetailerInfoEntity {
    @Id
    //@GeneratedValue
    @Column(name="Id")
    private Long Id;
    @Column(name="retailer_Name")
    private String retailerName;
    @Column(name="account_Id")
    private String accountId;
    @Column(name="active_Ind")
    private char activeInd;
    @Column(name="created_on")
    private LocalDateTime createdOn;
    @Column(name="updated_on")
    private LocalDateTime updatedOn;

}
