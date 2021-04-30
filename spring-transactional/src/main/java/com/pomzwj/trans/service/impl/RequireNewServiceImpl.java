package com.pomzwj.trans.service.impl;

import com.pomzwj.trans.dao.UserInfoMapper;
import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.RequireNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * require_new
 * @author zhaowj
 * @date 2021-04-29
 */
@Service
public class RequireNewServiceImpl implements RequireNewService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Override
	public void addRequire(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
	}

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addRequireNew(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
	}

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addRequireNewException(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
		throw new RuntimeException("这是一个Require_new异常");
	}
}
