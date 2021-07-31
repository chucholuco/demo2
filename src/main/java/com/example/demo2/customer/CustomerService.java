package com.example.demo2.customer;

import com.example.demo2.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Customer with id " + id + " not found"));
        /*return getCustomers().stream().filter(customer ->
                customer.getId().equals(id)).findFirst().orElseThrow(
                        () -> new NotFoundException("Customer with id " + id + " not found"));*/
    }

}
