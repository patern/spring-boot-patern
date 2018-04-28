package com.patern.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.patern.enums.UserSexEnum;

@Entity
public class User {
    @Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nickName="
				+ nickName + ", password=" + password + ", userSex=" + userSex
				+ ", age=" + age + "]";
	}

	public User(String userName, String password, int age) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public User() {
		super();
	}

	public User(String userName, String nickName, String password,
			UserSexEnum userSex, int age) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.userSex = userSex;
		this.age = age;
	}

	@Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String nickName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private UserSexEnum userSex;
    public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(nullable = false)
    private int age;

    public UserSexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}

	public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
