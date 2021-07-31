package com.example.demo2.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {



    /*@Override
    public List<Customer> getCustomers() {
        //TODO connect to real DB
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db", "TODO", "email@gmail.com")
        );
    }*/
}
