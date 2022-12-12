package com.mscourse.hroauth.services;

import com.mscourse.hroauth.entities.User;
import com.mscourse.hroauth.feignclients.UserFeignclients;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignclients userFeignclients;

    public User findByEmail(String email){
        User user = userFeignclients.findByEmail(email).getBody();
        if(user == null){
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignclients.findByEmail(username).getBody();
        if(user == null){
            logger.error("Email not found: " + username);
            throw new UsernameNotFoundException("User not found");
        }
        logger.info("User found: " + username);
        return user;
    }
}
