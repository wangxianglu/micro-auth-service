package com.dianmei.auth.repository;

import com.dianmei.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lout on 2017/4/12.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
