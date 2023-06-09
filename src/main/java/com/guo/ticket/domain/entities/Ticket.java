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
import com.guo.ticket.domain.repositories.TicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Date 2023/3/24.
 *
 * @author GuoJiangFu
 */
@Data
public class Ticket extends BaseDO {
    
    private String name;
    
    private String description;
    
    private Long price;
    
    @Autowired
    TicketRepository ticketRepository;
    
    
    public void delete() {
        Assert.notNull(code, "编码不能为空");
        ticketRepository.delete(code);
    }
    
    public void update() {
        Assert.notNull("code", "编码不能为空");
        ticketRepository.update(this);
    }
    
    public void save() {
        ticketRepository.add(this);
    }
}
