package com.nuzhd.dtopatternexample.repository;

import com.nuzhd.dtopatternexample.dto.CustomerDTO;
import com.nuzhd.dtopatternexample.mappers.CustomerDTOMapper;
import com.nuzhd.dtopatternexample.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(UUID.randomUUID().toString(), "Jack", "Williams", "jack@mail.ru", "aj312_c243k"),
            new Customer(UUID.randomUUID().toString(), "Anthony", "Jackson", "ant4313@mail.ru", "5f3__2a$sd"),
            new Customer(UUID.randomUUID().toString(), "John", "Adams", "johnny@mail.ru", "1j279h6o05n"),
            new Customer(UUID.randomUUID().toString(), "Ron", "Wizzley", "ron@hg.ru", "679240or5318n"),
            new Customer(UUID.randomUUID().toString(), "Arnold", "Browns", "arney-8@mail.ru", "4893d841a7371lo9nr"),
            new Customer(UUID.randomUUID().toString(), "Bob", "Browney", "bob@mail.ru", "yo3_3b1b$_1b22")
    ));


    private CustomerDTOMapper customerDTOMapper;

    public CustomerRepository(CustomerDTOMapper customerDTOMapper) {
        this.customerDTOMapper = customerDTOMapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOs = customers.stream()
                .map(customerDTOMapper)
                .toList();
        return customerDTOs;
    }

    public CustomerDTO addCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        return customerDTOMapper.apply(customer);
    }

    public CustomerDTO findByCustomerId(String customerId) {
        return customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst()
                .map(customerDTOMapper)
                .orElse(new CustomerDTO());
    }

    public boolean deleteCustomerById(String customerId) {
        return customers.removeIf(c -> c.getId().equals(customerId));
    }
}
