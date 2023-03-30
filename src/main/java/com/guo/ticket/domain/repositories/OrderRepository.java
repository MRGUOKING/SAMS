package com.guo.ticket.domain.repositories;

import com.guo.ticket.common.entity.Page;
import com.guo.ticket.domain.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderRepository {
    
    Order add(Order order);
    
    boolean deleteByCode(@Param("code") String code);
    
    List<Order> queryByUser(@Param("userCode") String userCode);
    
    Order findByCode(String code);
    
    List<Order> findAll(Page page);
    
    void update(Order order);
}
