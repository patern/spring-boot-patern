package com.patern.mapper;

import java.util.List;

import com.patern.entity.User;

public interface UserMapperA {
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

	User findByUserName(String userName);
}
