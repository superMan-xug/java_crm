package com.qakj.crm.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private Integer age;

    private String email;

    private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", age="
				+ age + ", email=" + email + ", role=" + role + "]";
	}

	public User(Integer id, String username, String password, String name, Integer age, String email, Integer role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.email = email;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String name, Integer age, String email, Integer role) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.email = email;
		this.role = role;
	}
    
}