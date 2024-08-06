package com.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BankInfo {
    private Long Id;
    private String bankName;
    private String ifscCode;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private boolean activeInd;
}
