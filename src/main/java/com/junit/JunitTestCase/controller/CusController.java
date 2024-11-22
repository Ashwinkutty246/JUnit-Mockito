package com.junit.JunitTestCase.controller;

import com.junit.JunitTestCase.model.Customer;
import com.junit.JunitTestCase.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CusController {

    @Autowired
    private CusService cusService;

    @PostMapping("/post")
    public Customer insertDetails(@RequestBody Customer customer) {
        return cusService.save(customer);
    }

    @GetMapping("/get")
    public List<Customer> getDetails() {
        return cusService.findall();
    }

    @GetMapping("/get/{id}")
    public Optional<Customer> getDetailsById(@PathVariable long id) {
        return cusService.findById(id);
    }
}
