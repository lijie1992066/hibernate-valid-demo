package com.lijie.valid.main;

import java.util.ArrayList;
import java.util.Date;

import com.lijie.valid.domain.Addr;
import com.lijie.valid.domain.User;
import com.lijie.valid.domain.ValidException;
import com.lijie.valid.utils.ValidUtils;

public class MainClass {

	public static void main(String[] args) {
		User u = new User();
		u.setAddr(new Addr());
		u.setBirthday(new Date());
		u.setId(-1);
		u.setUsername("");
		u.setList(new ArrayList<String>());
		u.setEmail("779261177@qq.com");
		ValidException validateEntity = ValidUtils.validateEntity(u);
		ValidException validateProperty = ValidUtils.validateProperty(u, "birthday");
		System.out.println(validateEntity);
		System.out.println();
		System.out.println(validateProperty);
	}
}
