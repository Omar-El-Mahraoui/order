package com.mygroupid.api.orders;

import com.mygroupid.domain.orders.Order;
import com.mygroupid.service.orders.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Inject
    private OrderService orderService;

    @GetMapping(path = "/today")
    public List<Order> getItemsShippingToday() {
        return orderService.getOrdersShippingToday();
    }

}
