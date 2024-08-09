package com.banking.repository;

import com.banking.entity.LoanInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;



public interface LoanInfoRepository extends JpaRepository<LoanInfoEntity, Long> {

    List<LoanInfoEntity> findByBankInfoEntityId(Long bankId);
      LoanInfoEntity findById(long id);

}
