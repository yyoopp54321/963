package com.example.zt.service;

import com.example.zt.common.SzpJsonResult;
import com.example.zt.dto.ResultDTO;
import com.example.zt.pojo.User;


/**
 * Author: zlp
 * Date: 2020-02-09 23:01
 * Description:UserService
 */
public interface UserService {

    Integer userRegister(User user);

    ResultDTO userLogin(String userName, String password);

    Integer alertUserInfo(User user);
}
