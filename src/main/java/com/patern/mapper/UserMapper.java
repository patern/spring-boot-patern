package com.patern.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.patern.entity.User;
import com.patern.enums.UserSexEnum;

public interface UserMapper {
	@Select("SELECT * FROM users")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name"),
		@Result(property = "userName", column = "user_name")
	})
	List<User> getAll();
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name"),
		@Result(property = "userName", column = "user_name")
	})
	User getOne(Long id);

	@Insert("INSERT INTO users(user_name,nick_name,password,user_sex,age) VALUES(#{userName}, #{nickName},#{password}, #{userSex},#{age})")
	void insert(User user);

	@Update("UPDATE users SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);
}
