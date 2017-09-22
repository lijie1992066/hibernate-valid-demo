package com.lijie.valid.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {

	@Min(value = 1, message = "id必须从1开始")
	private long id;

	@NotBlank(message = "username 不能为空")
	private String username;

	@Valid
	@NotNull(message = "addr不能为空")
	private Addr addr;

	@Past(message = "生日必须是过去的时间")
	private Date birthday;

	@Size(min = 2, message = "list长度必须大于1")
	@NotNull
	private List<String> list;

	@NotBlank(message = "email 不能为空")
	@Email(message = "email地址非法")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
