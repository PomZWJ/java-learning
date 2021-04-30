package com.pomzwj.trans.service;

import com.pomzwj.trans.entity.UserInfo;

/**
 * @author zhaowj
 * @date 2021-04-30
 */
public interface NotSupportService {
	void addRequire(UserInfo user);
	void addNotSupport(UserInfo user);
	void addNotSupportException(UserInfo user);
	void addRequire2(UserInfo user);
}
