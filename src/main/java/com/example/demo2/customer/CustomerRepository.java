package com.example.demo2.customer;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        //TODO connect to real DB
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db", "TODO", "email@gmail.com")
        );
    }
}
