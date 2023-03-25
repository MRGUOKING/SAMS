package com.guo.ticket.domain.repositories;

import com.guo.ticket.domain.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    
    User select(@Param("code") String account, @Param("password") String password);
    
    int add(User user);
    
    int update(User user);
    
    boolean deleteByCode(@Param("code") String code);
}
