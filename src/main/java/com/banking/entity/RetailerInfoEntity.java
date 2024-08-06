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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="retailer_Name")
    private String retailerName;
    @Column(name="account_Id")
    private String accountId;
    @Column(name="active_Ind")
    private boolean activeInd;
    @Column(name="created_On")
    private LocalDateTime createdOn;
    @Column(name="updated_On")
    private LocalDateTime updatedOn;

}
