package com.patern.service.impl;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.patern.dao.UserDao;
import com.patern.entity.User;
import com.patern.service.UserService;

@Service("userMongedbService")
public class UserServiceMongodbImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(User user) {
		this.rabbitTemplate.convertAndSend("user", user);
	}
    @Override
    public List<User> getUserList() {
        return userDao.getAll();
    }

    @Override
    @Cacheable(value="user-key")
    public User findUserById(long id) {
    	User u = userDao.getOne(id);
    	System.out.println("未从缓存中获取数据=================="+id);
        return u;
    }

    @Override
    public void save(User user) {
    	userDao.insert(user);
    	send(user);
    }

    @Override
    public void edit(User user) {
    	userDao.update(user);
    	send(user);
    }

    @Override
    public void delete(long id) {
    	userDao.delete(id);
    }
}


