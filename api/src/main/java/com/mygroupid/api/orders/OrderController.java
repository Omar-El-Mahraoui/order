package com.mygroupid.api.orders;

import com.mygroupid.domain.orders.Order;
import com.mygroupid.service.orders.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Inject
    private OrderService orderService;
    @Inject
    private OrderMapper orderMapper;

    @PostMapping(produces = TEXT_PLAIN_VALUE)
    public String createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.toDomain(orderDto);
        orderService.createOrder(order);
        return order.getPrice().toString();
    }

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.getOrders().stream()
                .map(orderMapper::toDto)
                .collect(toList());
    }

}

