package com.example.accio_shop.transformer;

import com.example.accio_shop.dto.request.CustomerRequest;
import com.example.accio_shop.dto.response.CustomerResponse;
import com.example.accio_shop.model.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerTransformer {

    public CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .createdAt(customer.getCreatedAt())
                .email(customer.getEmail())
                .build();
    }

    public Customer customerRequestToCustomer(CustomerRequest customerRequest) {
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setMobNo(customerRequest.getMobNo());
//        customer.setGender(customerRequest.getGender());
//        return customer;

        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .mobNo(customerRequest.getMobNo())
                .gender(customerRequest.getGender())
                .build();
    }
}
