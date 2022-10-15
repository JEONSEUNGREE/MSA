package com.example.orderservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Orders findByOrderId(String orderId);

    Iterable<Orders> findByUserId(String userId);

}
