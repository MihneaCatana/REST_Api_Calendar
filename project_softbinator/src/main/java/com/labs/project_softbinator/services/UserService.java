package com.labs.project_softbinator.services;

import com.labs.project_softbinator.dtos.UserDto;
import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(int id, UserDto user) {

        User oldUser = userRepository.findById(id).orElse(null);

        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        return userRepository.save(oldUser);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted ! id: " + id;
    }

}
