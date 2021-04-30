package com.pomzwj.trans.service;

import com.pomzwj.trans.entity.UserInfo;

/**
 * @author zhaowj
 * @date 2021-04-29
 */
public interface NestedService {
	void addNested(UserInfo user);
	void addNestedException(UserInfo user);
}
