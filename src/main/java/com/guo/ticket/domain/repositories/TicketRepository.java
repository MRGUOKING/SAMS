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

package com.guo.ticket.domain.repositories;

import com.guo.ticket.domain.entities.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Date 2023/3/24.
 *
 * @author GuoJiangFu
 */
@Mapper
public interface TicketRepository {
    
    Ticket add(Ticket ticket);
    
    boolean delete(@Param("code") String code);
    
    Ticket update(Ticket ticket);
    
    List<Ticket> getAllTickets();
    
    Ticket getTicketByCode(String code);
    
    void deleteTicketByCode(String code);
}
