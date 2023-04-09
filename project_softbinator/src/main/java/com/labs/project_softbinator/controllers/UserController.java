package com.labs.project_softbinator.controllers;

import com.labs.project_softbinator.dtos.UserDto;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/get")
    public List<User> findAllUsers()
    {
        return service.getUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserDto user){
            service.updateUser(id,user);
            return "User with id: "+ id +" was successfully updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        service.deleteUser(id);
        return "User Deleted with ID: "+id;
    }


}
