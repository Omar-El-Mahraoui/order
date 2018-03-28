package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerMapper;
import com.mygroupid.domain.orders.Order;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class OrderMapper {

    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private ItemGroupMapper itemGroupMapper;

    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCustomer(customerMapper.toDto(order.getCustomer()));
        orderDto.setItemGroup(itemGroupMapper.toDto(order.getItemGroup()));
        orderDto.setPrice(order.getPrice());
        return orderDto;
    }

    public Order toDomain(OrderDto orderDto) {
        Order order = new Order();
        order.setId();
        order.setCustomer(customerMapper.toDomain(orderDto.getCustomer()));
        order.setItemGroup(itemGroupMapper.toDomain(orderDto.getItemGroup()));
        order.setPrice(order.getPrice());
        return order;
    }

}
