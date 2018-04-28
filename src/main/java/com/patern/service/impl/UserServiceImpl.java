package com.patern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.patern.entity.User;
import com.patern.repository.UserRepository;
import com.patern.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value="user-key")
    public User findUserById(long id) {
    	User u = userRepository.findById(id);
    	System.out.println("未从缓存中获取数据=================="+id);
        return u;
    }

    @Override
    @Cacheable(value="user-key",key="id")
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Cacheable(value="user-key")
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}


