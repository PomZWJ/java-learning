package com.pomzwj.trans.service.impl;

import com.pomzwj.trans.dao.UserInfoMapper;
import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.RequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-04-29
 */
@Service
public class RequireServiceImpl implements RequireService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	//测试REQUIRE事务传播行为
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Override
	public void addRequire(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
	}

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Override
	public void addRequireException(UserInfo userInfo) {
		userInfoMapper.insert(userInfo);
		throw new RuntimeException("这个是一个require异常");
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	@Override
	public void addRequire2(UserInfo user) {
		userInfoMapper.insert(user);
		UserInfo ui = new UserInfo();
		ui.setName("老王");
		ui.setId(100);
		this.addNotSupportException(ui);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public void addNotSupportException(UserInfo user) {
		userInfoMapper.insert(user);
		throw new RuntimeException("not support异常");
	}
}
