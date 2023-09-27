package com.example.restapiexampl.controller;

import com.example.restapiexampl.dto.UserRequestDto;
import com.example.restapiexampl.dto.UserUpdateRequestDto;
import com.example.restapiexampl.entity.User;
import com.example.restapiexampl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public void  create(@RequestBody UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);
    }

    @GetMapping("/get-all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/find-by-id/{userId}")
    public User findById(@PathVariable Long userId) throws Exception {
        return userService.findById(userId);
    }

    @PutMapping("/update")
    public void update(@RequestBody UserUpdateRequestDto userUpdateRequestDto) throws Exception {
        userService.update(userUpdateRequestDto);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }


}
