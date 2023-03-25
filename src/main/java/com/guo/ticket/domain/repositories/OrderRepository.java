package com.guo.ticket.domain.repositories;

import com.guo.ticket.domain.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderRepository {
    Order add(Order order);
    
    boolean deleteByCode(@Param("code") String code);
    
    List<Order> queryByUser(@Param("userCode") String userCode);
}
