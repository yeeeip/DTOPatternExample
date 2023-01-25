package com.nuzhd.dtopatternexample.mappers;

import com.nuzhd.dtopatternexample.dto.CustomerDTO;
import com.nuzhd.dtopatternexample.model.Customer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}
