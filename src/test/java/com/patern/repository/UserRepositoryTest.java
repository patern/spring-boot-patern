package com.patern.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.patern.entity.User;



@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = {"classpath:application.properties"})
@SpringBootTest
@DatabaseSetup("todo-entries.xml")
public class UserRepositoryTest{
	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test() throws Exception {
		
		userRepository.save(new User("aa1","123455",2));
		userRepository.save(new User("bb2", "123455",2));
		userRepository.save(new User("cc3", "123455",2));
		Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals("123455", userRepository.findByUserName("aa1").getPassword());
	}
	@After
	public void tearDown() throws Exception {
		userRepository.deleteAll();
	}
}
