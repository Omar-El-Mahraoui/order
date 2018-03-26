package com.mygroupid.service.orders;

import com.mygroupid.domain.customers.Customer;
import com.mygroupid.domain.items.Item;
import com.mygroupid.domain.orders.ItemGroup;
import com.mygroupid.domain.orders.Order;
import com.mygroupid.domain.orders.OrderDatabase;
import com.mygroupid.service.customers.CustomerService;
import com.mygroupid.service.items.ItemService;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.Period.between;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.util.stream.Collectors.toList;

@Named
public class OrderService {

    @Inject
    private CustomerService customerService;
    @Inject
    private OrderDatabase orderDatabase;
    @Inject
    private ItemService itemService;

    public List<Order> getOrders() {
        return orderDatabase.getOrders();
    }

    public String calculatePrice(Order order) {
        return String.valueOf(parseDouble(itemService.getItem(order.getItemGroup().getItemId()).getPrice())
                * parseInt(order.getItemGroup().getAmount()));
    }

    public String calculateShippingDate(ItemGroup itemGroup) {
        Item item = itemService.getItem(itemGroup.getItemId());
        if (parseInt(item.getAmountInStock()) >= parseInt(itemGroup.getAmount())) {
            return LocalDate.now().plusDays(1).toString();
        } else {
            return LocalDate.now().plusDays(7).toString();
        }
    }

    public Order createOrder(String customerId, ItemGroup itemGroup) {
        validateOrder(itemGroup);
        Order order = new Order();
        order.setId();
        order.setCustomer(customerService.getCustomer(customerId));
        itemGroup.setShippingDate(calculateShippingDate(itemGroup));
        order.setItemGroup(itemGroup);
        order.setPrice(calculatePrice(order));
        itemService.getItem(itemGroup.getItemId()).decrementAmountInStock(itemGroup.getAmount());
        itemService.setUrgencyIndicatorForItem(itemService.getItem(itemGroup.getItemId()));
        return orderDatabase.createOrder(order);
    }

    private void validateOrder(ItemGroup itemGroup) {
        if (parseInt(itemGroup.getAmount()) > parseInt(itemService.getItem(itemGroup.getItemId()).getAmountInStock())) {
            throw new IllegalArgumentException(format("Out of stock. There are only %s \"%s\" available."
                                                        , itemService.getItem(itemGroup.getItemId()).getAmountInStock()
                                                        , itemService.getItem(itemGroup.getItemId()).getName()));
        }
    }

    public List<Order> getReportOfOrders(String customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return orderDatabase.getOrders().stream()
                .filter(order->order.getCustomer().equals(customer))
                .collect(toList());
    }

    public Order createReOrder(String customerId, String orderId) {
        Order orderToReOrder = orderDatabase.getOrders().stream()
                .filter(order->order.getCustomer().getId().equals(customerId) && order.getId().equals(orderId))
                .findFirst()
                .get();
        createOrder(customerId, orderToReOrder.getItemGroup());
        itemService.getItem(orderToReOrder.getItemGroup().getItemId())
                .decrementAmountInStock(orderToReOrder.getItemGroup().getAmount());
        return orderToReOrder;
    }

    public List<Order> getOrdersShippingToday() {
        return getOrders().stream()
                .filter(order->order.getItemGroup().getShippingDate().equals(now().toString()))
                .collect(toList());
    }

    public boolean wasOrderedInLast7Days(String itemId) {
        return getOrders().stream()
                .filter(order -> order.getItemGroup().getItemId().equals(itemId))
                .collect(toList())
                .stream()
                // https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
                .filter(order -> between(parse(order.getItemGroup().getShippingDate(), ISO_LOCAL_DATE)
                                                , now()).getDays() <= 7)
                .collect(toList())
                .size() != 0;
    }
}
