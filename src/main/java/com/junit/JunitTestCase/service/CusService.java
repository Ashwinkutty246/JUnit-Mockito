package com.junit.JunitTestCase.service;

import com.junit.JunitTestCase.model.Customer;
import com.junit.JunitTestCase.repository.CusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusService {

    @Autowired
    private CusRepo cusRepo;
    public List<Customer> findall() {
        return cusRepo.findAll();
    }

    public Customer save(Customer customer) {
        return cusRepo.save(customer);
    }

    public Optional<Customer> findById(long id) {
        return cusRepo.findById(id);
    }
}
