package com.example.accio_shop.service;

import com.example.accio_shop.dto.request.CustomerRequest;
import com.example.accio_shop.dto.response.CustomerResponse;
import com.example.accio_shop.exception.CustomerNotFoundException;
import com.example.accio_shop.model.Customer;
import com.example.accio_shop.repository.CustomerRepository;
import com.example.accio_shop.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // Step 1 - Request DTO - Entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        // Save entity
        Customer savedCustomer = customerRepository.save(customer);
        // Step 3 - Convert saved entity into response
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid id");
        }
        Customer customer = optionalCustomer.get();
        return CustomerTransformer.customerToCustomerResponse(customer);
    }





}
