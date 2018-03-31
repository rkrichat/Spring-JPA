package com.spring.jpa.controller;

import com.spring.jpa.model.UserInfo;
import com.spring.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<UserInfo> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public UserInfo findByName(@PathVariable String name){
        return userRepository.findByName(name);
    }

    @PutMapping
    public UserInfo save(@RequestBody UserInfo userInfo){
        userRepository.save(userInfo);
        return userRepository.findById(userInfo.getId());
    }

    @DeleteMapping
    public String delete(@RequestBody UserInfo userInfo){
        if(userRepository.findById(userInfo.getId())!=null) {
            userRepository.delete(userInfo);
            return "Delete Successfully";
        }
        return "Invalid User";
    }

}
