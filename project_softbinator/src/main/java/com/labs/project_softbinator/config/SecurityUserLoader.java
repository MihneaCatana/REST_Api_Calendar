package com.labs.project_softbinator.config;


import com.labs.project_softbinator.models.User;
import com.labs.project_softbinator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SecurityUserLoader implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public SecurityUserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User loadedUser = userRepository.findUserByName(name);
        System.out.println(loadedUser);
        if (loadedUser == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(loadedUser.getName(), loadedUser.getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+loadedUser.getRole())));
    }
}
