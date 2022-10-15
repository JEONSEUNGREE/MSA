package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.jpa.OrderRepository;
import com.example.orderservice.jpa.Orders;
import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

//      모델 맵퍼로 dto 변환
        ModelMapper mapper = new ModelMapper();
//      설정 강력하게 딱 맞아 떨어져야 변환
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Orders orders = mapper.map(orderDto, Orders.class);
        orderRepository.save(orders);

        OrderDto returnValue = mapper.map(orders, OrderDto.class);

        return returnValue;
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        Orders order = orderRepository.findByOrderId(orderId);
        return new ModelMapper().map(order, OrderDto.class);
    }

    @Override
    public Iterable<Orders> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

}
