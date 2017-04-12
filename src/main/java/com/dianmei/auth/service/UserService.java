package com.dianmei.auth.service;

import com.dianmei.auth.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by lout on 2017/4/12.
 */
public interface UserService {

    void create(User user);
}
