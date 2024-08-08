package com.banking.repository;

import com.banking.entity.CustomerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfoEntity, Long> {

    List<CustomerInfoEntity> findByActiveIndIsTrue();
}
