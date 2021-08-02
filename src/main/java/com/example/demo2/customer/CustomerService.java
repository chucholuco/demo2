package com.example.demo2.customer;

import com.example.demo2.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){

        return customerRepository.findById(id).orElseThrow(
                () -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
                    LOGGER.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
        /*return getCustomers().stream().filter(customer ->
                customer.getId().equals(id)).findFirst().orElseThrow(
                        () -> new NotFoundException("Customer with id " + id + " not found"));*/
    }

}
