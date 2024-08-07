package com.banking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banker")

public class BankInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="bank_Name")
    private String bankName;
    @Column(name="ifsc_Code")
    private String ifscCode;
    @Column(name="created_On")
    private LocalDateTime createdOn;
    @Column(name="updated_On")
    private LocalDateTime updatedOn;
    @Column(name="active_Ind")
    private boolean activeInd;

    @OneToMany(mappedBy = "bankInfoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanInfoEntity> loanInfoEntityList;
}
