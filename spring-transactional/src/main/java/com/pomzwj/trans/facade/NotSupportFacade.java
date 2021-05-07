package com.pomzwj.trans.facade;

import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.NotSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-05-07
 */
@Component
public class NotSupportFacade {
	@Autowired
	private NotSupportService notSupportService;


	public void noTransNotSupport1(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");


		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		notSupportService.addRequire(userInfo0);
		notSupportService.addNotSupport(userInfo1);
		notSupportService.addNotSupportException(userInfo2);
	}
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	public void createTransNotSupport1(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");


		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		notSupportService.addRequire(userInfo0);
		notSupportService.addNotSupport(userInfo1);
		notSupportService.addNotSupportException(userInfo2);
	}

}
