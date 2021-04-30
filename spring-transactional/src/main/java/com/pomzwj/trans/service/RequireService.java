package com.pomzwj.trans.service;

import com.pomzwj.trans.entity.UserInfo;

/**
 * @author zhaowj
 * @date 2021-04-29
 */
public interface RequireService {
	//PROPAGATION_REQUIRED
	void addRequire(UserInfo userInfo);
	void addRequireException(UserInfo userInfo);
}
