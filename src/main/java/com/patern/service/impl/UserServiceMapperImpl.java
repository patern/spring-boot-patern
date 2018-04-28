package com.patern.service.impl;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.patern.entity.User;
import com.patern.mapper.UserMapperA;
import com.patern.service.UserService;

@Service("userMapperService")
public class UserServiceMapperImpl implements UserService{

	@Autowired
    private UserMapperA userMapper;
    @Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(User user) {
		this.rabbitTemplate.convertAndSend("user", user);
	}
    @Override
    public List<User> getUserList() {
        return userMapper.getAll();
    }

    @Override
    @Cacheable(value="user-key")
    public User findUserById(long id) {
    	User u = userMapper.getOne(id);
    	System.out.println("未从缓存中获取数据=================="+id);
        return u;
    }

    @Override
    public void save(User user) {
    	userMapper.insert(user);
    	send(user);
    }

    @Override
    public void edit(User user) {
    	userMapper.update(user);
    	send(user);
    }

    @Override
    public void delete(long id) {
    	userMapper.delete(id);
    }
}


