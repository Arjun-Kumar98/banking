package com.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {
private Long Id;
private String accountId;
private String customerName;
private LocalDateTime createdOn;
private LocalDateTime updatedOn;
private char activeInd;
}
