package com.mscourse.hroauth.services;

import com.mscourse.hroauth.entities.User;
import com.mscourse.hroauth.feignclients.UserFeignclients;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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

}
