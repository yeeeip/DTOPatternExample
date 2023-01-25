package com.nuzhd.dtopatternexample.controller;

import com.nuzhd.dtopatternexample.dto.CustomerDTO;
import com.nuzhd.dtopatternexample.model.Customer;
import com.nuzhd.dtopatternexample.model.CustomerAddRequest;
import com.nuzhd.dtopatternexample.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerRepository customerRepository;


    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable("customerId") String customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerAddRequest customerAddRequest) {
        Customer customer = new Customer(
                customerAddRequest.getFirstName(),
                customerAddRequest.getLastName(),
                customerAddRequest.getEmail(),
                customerAddRequest.getPassword()
        );

        return customerRepository.addCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") String customerId) {

        String response = customerRepository.deleteCustomerById(customerId) ?
                "Customer with id " + customerId + " has been deleted" :
                "No customers were deleted";

        return ResponseEntity.ok(response);
    }


}
