package com.mygroupid.api.customers;

import com.mygroupid.api.orders.ItemGroupDto;
import com.mygroupid.api.orders.ItemGroupMapper;
import com.mygroupid.api.orders.OrderDto;
import com.mygroupid.api.orders.OrderMapper;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.orders.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
//copied and adapted code from funiversity example switchfully


@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Inject
    private CustomerService customerService;
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private OrderMapper orderMapper;
    @Inject
    private OrderService orderService;
    @Inject
    private ItemGroupMapper itemGroupMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.toDto(
                customerService.createCustomer(customerMapper.toDomain(customerDto)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomer(@PathVariable("customerId") String customerId) {
        return customerMapper.toDto(customerService.getCustomer(customerId));
    }

    @PostMapping(path = "/{customerId}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@PathVariable("customerId") String customerId
                                , @RequestBody ItemGroupDto[] itemGroupDtos) {
        return orderMapper.toDto(orderService.createOrder(itemGroupMapper.toDomain(itemGroupDtos)
                , customerService.getCustomer(customerId)));
    }

}
