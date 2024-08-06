package com.banking.repository;

import com.banking.entity.RetailerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface RetailerInfoRepository extends JpaRepository<RetailerInfoEntity, Long> {
    List<RetailerInfoEntity> findByActiveIndIsTrue();
}
