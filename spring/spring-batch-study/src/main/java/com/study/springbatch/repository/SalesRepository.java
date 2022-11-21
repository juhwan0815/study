package com.study.springbatch.repository;

import com.study.springbatch.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
