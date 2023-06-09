/*
 * Copyright 1999-2022 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guo.ticket.domain.entities;

import com.guo.ticket.common.entity.BaseDO;
import com.guo.ticket.domain.repositories.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.sql.Date;

/**
 * Date 2023/3/25.
 *
 * @author GuoJiangFu
 */
@Data
public class Order extends BaseDO {
    
    private Date ticketDate;
    
    private String ticketCode;
    
    private String userCode;
    
    private Integer actualPrice;
    
    private String discountCategoryCodes;
    
    
    @Autowired
    OrderRepository orderRepository;
    
    public Order save() {
        orderRepository.add(this);
        return this;
    }
    
    public void update() {
        Assert.notNull(code, "编号不存在");
        orderRepository.update(this);
    }
    
    public void delete() {
        Assert.notNull(code, "编号不存在");
        orderRepository.deleteByCode(code);
    }
}
