package com.patern.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.patern.dao.UserDao;
import com.patern.entity.User;
import com.patern.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMongodbDaoTest {

    @Autowired
    private UserDao userMongodbDao;

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(3l);
        user.setUserName("小明");
        user.setAge(5);
        user.setUserSex(UserSexEnum.MALE);
        user.setPassword("fffooo123");
        user.setNickName("XM");
        userMongodbDao.insert(user);
    }

    @Test
    public void findUserByUserName(){
       User user= userMongodbDao.findByUserName("小明");
       System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassword("fffxxxx");
        userMongodbDao.update(user);
    }

    @Test
    public void deleteUserById(){
        userMongodbDao.delete(1l);
    }

}
