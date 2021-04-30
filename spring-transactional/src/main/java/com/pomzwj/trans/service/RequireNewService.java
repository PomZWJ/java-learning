package com.pomzwj.trans.service;

import com.pomzwj.trans.entity.UserInfo;

/**
 * @author zhaowj
 * @date 2021-04-29
 */
public interface RequireNewService {
	//PROPAGATION_REQUIRED_NEW
	void addRequire(UserInfo userInfo);
	void addRequireNew(UserInfo userInfo);
	void addRequireNewException(UserInfo userInfo);
}
