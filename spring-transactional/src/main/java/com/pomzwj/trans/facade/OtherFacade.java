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
public class OtherFacade {
	@Autowired
	private RequireService requireService;

	@Transactional(propagation = Propagation.REQUIRED)
	public void createTransServiceFork(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");
		requireService.addRequire2(userInfo0);
	}
}
