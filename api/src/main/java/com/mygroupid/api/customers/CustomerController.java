package com.mygroupid.api.customers;

import com.mygroupid.api.orders.OrderDto;
import com.mygroupid.api.orders.OrderMapper;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.orders.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;
// copied and adapted code from funiversity

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.toDto(customerService.createCustomer(customerMapper.toDomain(customerDto)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers().stream()
                .map(customerMapper::toDto)
                .collect(toList());
    }

    @PostMapping(path = "/orders", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderDto orderDto) {
        return customerService
                .order(orderMapper.toDomain(orderDto))
                .getPrice()
                .toString();
    }

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.getOrders().stream()
                .map(orderMapper::toDto)
                .collect(toList());
    }

}
