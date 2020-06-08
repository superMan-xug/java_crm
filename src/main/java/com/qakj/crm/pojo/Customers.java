package com.qakj.crm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Customers {
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private String email;

    private String phone;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date birth;

    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

	public Customers(Integer id, String name, Integer age, Integer sex, String email, String phone, Date birth,
			Integer level) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.level = level;
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(String name, Integer age, Integer sex, String email, String phone, Date birth, Integer level) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.level = level;
	}
    
}