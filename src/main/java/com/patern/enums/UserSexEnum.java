package com.patern.enums;

public enum UserSexEnum {
	MALE("MALE","男"), FEMALE("FEMALE","女");
	private String key;
    private UserSexEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	// 成员变量  
    private String value;

	public String getValue() {
		return value;
	}

	private UserSexEnum(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static UserSexEnum getEnum(String i) {
		switch(i){
			case "FEMALE":return UserSexEnum.FEMALE;
			case "MALE":return UserSexEnum.MALE;
		}
		
		return null;
	}
}
