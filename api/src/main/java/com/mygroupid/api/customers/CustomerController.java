package com.mygroupid.api.customers;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.orders.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Inject
    private CustomerService customerService;
    @Inject
    private OrderService orderService;
    @Inject
    private CustomerMapper customerMapper;

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.toDto(
                customerService.createCustomer(customerMapper.toDomain(customerDto)));
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping(path = "/{customerId}/order")
    public Order createOrder(@PathVariable String customerId
                            , @RequestBody ItemGroup itemGroup) {
        return orderService.createOrder(customerId, itemGroup);
    }

    @GetMapping(path = "/{customerId}/orders")
    public List<Order> getReportOfOrders(@PathVariable String customerId) {
        return orderService.getReportOfOrders(customerId);
    }

    @PostMapping(path = "/{customerId}/re-order")
    public Order createReOrder(@PathVariable String customerId
            , @RequestParam String orderId) {
        return orderService.createReOrder(customerId, orderId);
    }

}
