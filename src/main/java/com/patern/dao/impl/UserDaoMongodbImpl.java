package com.patern.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.patern.dao.UserDao;
import com.patern.entity.User;

@Component
public class UserDaoMongodbImpl implements UserDao{


	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 根据用户名查询对象
	 * 
	 * @param userName
	 * @return
	 */
	@Override
	public User findByUserName(String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}


	@Override
	public List<User> getAll() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getOne(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public void insert(User user) {
		mongoTemplate.save(user);
	}

	@Override
	public void update(User user) {
		Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update().set("userName", user.getUserName()).set(
				"password", user.getPassword());
		// 更新查询返回结果集的第一条
		mongoTemplate.updateFirst(query, update, User.class);
		// 更新查询返回结果集的所有
		// mongoTemplate.updateMulti(query,update,User.class);
		
	}

	@Override
	public void delete(Long id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, User.class);
	}

}
