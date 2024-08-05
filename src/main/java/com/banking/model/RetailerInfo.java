package com.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RetailerInfo {
    private Long Id;
    private String accountId;
    private String retailerName;
    private char activeInd;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
