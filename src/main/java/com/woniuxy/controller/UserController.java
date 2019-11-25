package com.woniuxy.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController



@RequestMapping("users")

public class UserController {





    @Autowired
    private IUserService userService;



    @GetMapping
    public PageInfo findAll(@RequestParam(value = "pn",defaultValue = "2") Integer pn){

        PageHelper.startPage(pn,5);
        List<User> list = userService.findAll();

        PageInfo page = new PageInfo(list,5);


        System.out.println("hello world");
        return page;

    }


    @DeleteMapping
    public void delete( Integer uid){
        userService.delete(uid);



    }

    @PutMapping
    public void update(@RequestBody User user){

        userService.update(user);


        System.out.println("chong");

    }

    @PostMapping
    public void save(@RequestBody User user){

        userService.save(user);

    }


    @GetMapping(value = "/{uid}")
    public User  findOne(@RequestParam Integer uid){
        return userService.findOne(uid);


    }
}

