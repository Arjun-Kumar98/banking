package com.banking.repository;

import com.banking.entity.BankInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.List;

public interface BankInfoRepository extends JpaRepository<BankInfoEntity, Long> {
List<BankInfoEntity> findByActiveIndIsTrue();
}
