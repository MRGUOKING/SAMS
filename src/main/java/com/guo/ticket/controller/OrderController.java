package com.guo.ticket.controller;

import com.guo.ticket.common.entity.Page;
import com.guo.ticket.common.entity.Response;
import com.guo.ticket.domain.entities.Order;
import com.guo.ticket.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @GetMapping("/{code}")
    public Response<Order> getOrder(@PathVariable String code) {
        Order order = orderRepository.findByCode(code);
        if (order != null) {
            return Response.success(order);
        } else {
            return Response.fail("Order not found");
        }
    }
    
    @PostMapping
    public Response<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = order.save();
        return Response.success(savedOrder);
    }
    
    @PutMapping("/{code}")
    public Response<Order> updateOrder(@PathVariable String code, @RequestBody Order order) {
        Order existingOrder = orderRepository.findByCode(code);
        if (existingOrder != null) {
            order.update();
            return Response.success(null);
        } else {
            return Response.fail("Order not found");
        }
    }
    
    @DeleteMapping("/{code}")
    public Response<Void> deleteOrder(@PathVariable String code) {
        Order existingOrder = orderRepository.findByCode(code);
        if (existingOrder != null) {
            existingOrder.delete();
            return Response.success(null);
        } else {
            return Response.fail("Order not found");
        }
    }
    
    @GetMapping
    public Response<List<Order>> getAllOrders(Page page) {
        List<Order> orderPage = orderRepository.findAll(page);
        return Response.success(orderPage);
    }
}
