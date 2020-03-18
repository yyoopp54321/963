package com.example.zt.service.impl;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.dao.UserDao;
import com.example.zt.dto.ResultDTO;
import com.example.zt.error.CommonErrorCode;
import com.example.zt.pojo.User;
import com.example.zt.service.UserService;
import com.example.zt.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Author: zlp
 * Date: 2020-02-09 23:07
 * Description:UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Integer userRegister(User user) {
        return userDao.userRegister(user);
    }

    @Override
    public ResultDTO userLogin(String userName, String password) {

            Integer integer = 0;
            String token = UUID.randomUUID().toString();
            User user1 = userDao.userLogin(userName, password);
            if (user1!= null) {
                user1.setToken(token);
                integer = userDao.updateUser(user1);
            }
            if (integer == 1) {
                String tpstring = JsonUtils.objectToJson(user1);
                stringRedisTemplate.opsForValue().set(token, tpstring, 2, TimeUnit.DAYS);
                return ResultDTO.ok(token,user1.getId());
            } else {
                return ResultDTO.fail(CommonErrorCode.UNKOWN_ERROR);
            }

    }


    @Override
    public Integer alertUserInfo(User user) {
        return userDao.alterUserInfo(user);
    }
    
}
