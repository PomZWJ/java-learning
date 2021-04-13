package com.pomzwj.trans;

import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TransApplication.class)
public class TestApplication {
	@Autowired
	private IUserInfoService userInfoService;

	@Test
	public void test1(){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("15859706666");
		userInfo.setUserName("yzx");
		userInfo.setCreateDate("20210413");
		userInfo.setCreateTime("163500");
		userInfo.setAccountStatus("1");
		userInfoService.addUser1(userInfo);
	}
}
