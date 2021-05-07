package com.pomzwj.trans.facade;

import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.RequireNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-05-07
 */
@Component
public class RequireNewFacade {
	@Autowired
	private RequireNewService requireNewService;

	public void noTransRequireNew1(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireNewService.addRequireNew(userInfo1);
		requireNewService.addRequireNew(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}

	public void noTransRequireNew2(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireNewService.addRequireNew(userInfo1);
		requireNewService.addRequireNewException(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransRequireNew1(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");

		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");
		requireNewService.addRequire(userInfo0);
		requireNewService.addRequireNew(userInfo1);
		requireNewService.addRequireNew(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransRequireNew2(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");


		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireNewService.addRequire(userInfo0);
		requireNewService.addRequireNew(userInfo1);
		requireNewService.addRequireNewException(userInfo2);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransRequireNew3_try(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");


		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireNewService.addRequire(userInfo0);
		requireNewService.addRequireNew(userInfo1);
		try{
			requireNewService.addRequireNewException(userInfo2);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
