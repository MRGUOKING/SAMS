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
import com.guo.ticket.domain.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Date 2023/3/24.
 *
 * @author GuoJiangFu
 */
@Data
public class User extends BaseDO {
    
    private String account;
    
    private String password;
    
    private String name;
    
    private String avatarUrl;
    
    private String nickName;
    
    /**
     * 0 普通用户， 1 普通管理员， 2 超级管理员
     */
    private Short roleType;
    
    /**
     * 0 未知， 1 男， 2 女
     */
    private Short sex;
    
    @Autowired
    UserRepository userRepository;
    
    public void save() {
        userRepository.add(this);
    }
    
    public void deleteUser() {
        Assert.notNull(this.getCode(), "用户编码不存在");
        userRepository.deleteByCode(this.getCode());
    }
    
    public boolean updateUser(){
        Assert.notNull(this.getCode(), "用户编码不存在");
        return userRepository.update(this) > 0;
    }
    
    public User query(String account, String password) {
        Assert.notNull("account", "账号不能为空");
        Assert.notNull(password, "密码不能为空");
        return userRepository.select(account, password);
    }
}
