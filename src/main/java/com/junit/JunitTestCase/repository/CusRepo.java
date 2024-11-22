package com.junit.JunitTestCase.repository;

import com.junit.JunitTestCase.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CusRepo extends JpaRepository<Customer,Long> {
}
