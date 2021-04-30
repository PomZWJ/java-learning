package com.pomzwj.trans.entity;

import java.io.Serializable;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
public class UserInfo implements Serializable {

	private Integer id;

	private String name;

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
		this.name = name;
	}
}
