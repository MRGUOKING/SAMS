package com.guo.ticket.controller;

import com.guo.ticket.common.entity.Page;
import com.guo.ticket.common.entity.Response;
import com.guo.ticket.domain.entities.User;
import com.guo.ticket.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("")
    public Response listUsers(Page page) {
        List<User> users = userRepository.listUser(page);
        return Response.success(users);
    }
    
    @GetMapping("/{id}")
    public Response getUserById(@PathVariable("id") String id) {
        User user = userRepository.selectByCodeUser(id);
        if (user != null) {
            return Response.success(user);
        } else {
            return Response.fail("查询用户失败");
        }
    }
    
    @PostMapping("")
    public Response createUser(@RequestBody User user) {
        user.setCode(UUID.randomUUID().toString());
        user.save();
        return Response.success(null);
    }
    
    @PutMapping("/{id}")
    public Response updateUser(@RequestBody User user) {
        try {
            user.updateUser();
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable("id") String id) {
        User user = new User();
        user.setCode(id);
        try {
            user.deleteUser();
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(e.getMessage());
        }
    }
}
