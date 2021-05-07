package com.pomzwj.trans.facade;

import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.NestedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-05-07
 */
@Component
public class NestedFacade {
	@Autowired
	private NestedService nestedService;

	public void noTransNested1(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");
		nestedService.addNested(userInfo1);
		nestedService.addNested(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}

	public void noTransNested2(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");
		nestedService.addNested(userInfo1);
		nestedService.addNestedException(userInfo2);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransNested1(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");
		nestedService.addNested(userInfo1);
		nestedService.addNested(userInfo2);
		throw new RuntimeException("我是一个Test异常");
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransNested2(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");
		nestedService.addNested(userInfo1);
		nestedService.addNestedException(userInfo2);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransNested3_try(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");
		nestedService.addNested(userInfo1);
		try{
			nestedService.addNestedException(userInfo2);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
