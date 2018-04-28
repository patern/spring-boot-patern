package com.patern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patern.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    Long deleteById(Long id);

	User findByUserName(String userName);
}