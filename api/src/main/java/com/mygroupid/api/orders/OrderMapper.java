/*
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
        return new OrderDto(
                customerMapper.toDto(order.getCustomer()),
                itemGroupMapper.toDto(order.getItemGroup())
        );
    }

    public Order toDomain(OrderDto orderDto) {
        return new Order(
                customerMapper.toDomain(orderDto.getCustomer()),
                itemGroupMapper.toDomain(orderDto.getItemGroups())
        );
    }

}
*/
