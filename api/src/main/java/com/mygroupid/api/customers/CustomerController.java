package com.mygroupid.api.customers;

import com.mygroupid.service.customers.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Inject
    private CustomerService customerService;
    @Inject
    private CustomerMapper customerMapper;


    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.toDto(
                customerService.createCustomer(customerMapper.toDomain(customerDto)));
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

}
