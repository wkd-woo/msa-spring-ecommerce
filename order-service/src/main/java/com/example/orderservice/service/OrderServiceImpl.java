package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.jpa.Order;
import com.example.orderservice.jpa.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Order order = mapper.map(orderDto, Order.class);

        orderRepository.save(order);

        OrderDto result = mapper.map(order, OrderDto.class);

        return result;

    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        OrderDto orderDto = new ModelMapper().map(order, OrderDto.class);

        return orderDto;
    }

    @Override
    public Iterable<Order> getOrdersByUserId(String userId) {

        return orderRepository.findByUserId(userId);
    }
}
