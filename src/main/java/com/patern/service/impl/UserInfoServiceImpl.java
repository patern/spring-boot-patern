package com.patern.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patern.dao.UserInfoDao;
import com.patern.entity.UserInfo;
import com.patern.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
