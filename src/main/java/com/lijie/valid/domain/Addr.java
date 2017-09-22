package com.lijie.valid.domain;

import org.hibernate.validator.constraints.NotBlank;

public class Addr {

	@NotBlank(message = "地址不能为空")
	private String address;

	private boolean isZX;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isZX() {
		return isZX;
	}

	public void setZX(boolean isZX) {
		this.isZX = isZX;
	}

}
