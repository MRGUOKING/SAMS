package com.guo.ticket.infrastructure.mapper;

import com.guo.ticket.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDAO {
    
    User selectByCode(@Param("code") String code);
    
    User add(User user);
    
    User update(User user);
    
    boolean deleteByCode(@Param("code") String code);
}
