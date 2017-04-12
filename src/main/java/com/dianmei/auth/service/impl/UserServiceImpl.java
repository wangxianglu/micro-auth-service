package com.dianmei.auth.service.impl;

import com.dianmei.auth.domain.User;
import com.dianmei.auth.repository.UserRepository;
import com.dianmei.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by lout on 2017/4/12.
 */
@Service
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {

        User existing = userRepository.findOne(user.getUsername());
        Assert.isNull(existing, "user already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        userRepository.save(user);

        logger.info("new user has been created: {}", user.getUsername());
    }
}
