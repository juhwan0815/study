package com.study.springbatch.repository;

import com.study.springbatch.domain.SalesSum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesSumRepository extends JpaRepository<SalesSum, Long> {
}
