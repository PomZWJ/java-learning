package com.pomzwj.trans.service.impl;

import com.pomzwj.trans.dao.UserInfoMapper;
import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.NestedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-04-29
 */
@Service
public class NestedServiceImpl implements NestedService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
	@Override
	public void addNested(UserInfo user){
		userInfoMapper.insert(user);
	}

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
	@Override
	public void addNestedException(UserInfo user){
		userInfoMapper.insert(user);
		throw new RuntimeException();
	}
}
