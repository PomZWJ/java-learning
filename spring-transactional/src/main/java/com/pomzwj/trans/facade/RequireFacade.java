package com.pomzwj.trans.facade;

import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.RequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-05-07
 */
@Component
public class RequireFacade {
	@Autowired
	private RequireService requireService;

	public void noTransRequire1(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireService.addRequire(userInfo1);
		requireService.addRequire(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}

	public void noTransRequire2(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireService.addRequire(userInfo1);
		requireService.addRequireException(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransRequire1(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireService.addRequire(userInfo1);
		requireService.addRequire(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransRequire2(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireService.addRequire(userInfo1);
		requireService.addRequireException(userInfo2);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransRequire3_try(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireService.addRequire(userInfo1);

		try{
			requireService.addRequireException(userInfo2);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

}
