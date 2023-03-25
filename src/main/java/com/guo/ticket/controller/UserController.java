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

package com.guo.ticket.controller;

import com.guo.ticket.domain.User;
import com.guo.ticket.infrastructure.mapper.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date 2023/3/24.
 *
 * @author GuoJiangFu
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserDAO userDAO;
    
    @GetMapping("/queryByCode")
    public User queryByCode(@RequestParam String code) {
        User user = userDAO.selectByCode(code);
        return user;
    }
}
