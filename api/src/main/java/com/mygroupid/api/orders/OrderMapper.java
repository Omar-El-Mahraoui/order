package com.mygroupid.api.orders;

import com.mygroupid.api.customers.CustomerMapper;
import com.mygroupid.domain.orders.Order;

import javax.inject.Inject;
import javax.inject.Named;

import java.math.BigDecimal;

import static com.mygroupid.api.orders.OrderDto.orderDto;
import static com.mygroupid.domain.orders.Order.OrderBuilder.order;

@Named
public class OrderMapper {

    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private ItemGroupMapper itemGroupMapper;

    public OrderDto toDto(Order order) {
        return orderDto()
                .withId(order.getId().toString())
                .withCustomerDto(customerMapper.toDto(order.getCustomer()))
                .withItemGroupsDto(itemGroupMapper.toDto(order.getItemGroups()))
                .withPrice(order.getPrice().toString());
    }

    public Order toDomain(OrderDto orderDto) {
        return order()
                .withCustomer(customerMapper.toDomain(orderDto.getCustomer()))
                .withItemGroups(itemGroupMapper.toDomain(orderDto.getItemGroups()))
                .withPrice(new BigDecimal(orderDto.getPrice()))
                .build();
    }

}
