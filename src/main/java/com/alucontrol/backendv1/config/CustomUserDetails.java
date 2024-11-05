package com.alucontrol.backendv1.config;

import com.alucontrol.backendv1.repository.UserRepository;
import com.alucontrol.backendv1.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoggerUtil.info("Start searching ... username: " + username);

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {

            LoggerUtil.info("Found user: " + user.get().getUsername());

            return new User(
                user.get().getUsername(),
                user.get().getPassword(),
                user.get().getAuthorities());
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }
}
