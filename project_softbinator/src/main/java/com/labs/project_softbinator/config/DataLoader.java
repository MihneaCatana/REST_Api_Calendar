package com.labs.project_softbinator.config;

import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository repository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.repository = userRepository;
    }

    //Used for creating the initial account
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        repository.save(new User(1,"admin@email.com","Admin","12345","ADMIN"));
//        repository.save(new User(2,"ionutpopescu@gmail.com","Ionut Popescu","abcd","CUSTOMER"));
//        repository.save(new User(3,"davidandrei@gmail.com","David Andrei","test","EMPLOYEE"));
    }
}