package com.mygroupid.api.orders;

import com.mygroupid.service.orders.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Inject
    private OrderService orderService;
    @Inject
    private OrderMapper orderMapper;



}

