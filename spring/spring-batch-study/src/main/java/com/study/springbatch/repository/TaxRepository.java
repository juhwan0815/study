package com.study.springbatch.repository;

import com.study.springbatch.domain.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
