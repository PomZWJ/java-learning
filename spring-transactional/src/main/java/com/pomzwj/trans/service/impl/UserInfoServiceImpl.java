package com.pomzwj.trans.service.impl;

import com.pomzwj.trans.dao.UserInfoMapper;
import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

	private static Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addUser1(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
		this.addUser2(userInfo);
		int a = 1/0;
	}
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.NOT_SUPPORTED)
	@Override
	public void addUser2(UserInfo userInfo) {
		userInfo.setUserId("111111");
		userInfoMapper.insert(userInfo);
	}
}
