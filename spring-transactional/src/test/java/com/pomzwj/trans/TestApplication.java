package com.pomzwj.trans;

import com.pomzwj.trans.entity.UserInfo;
import com.pomzwj.trans.service.NestedService;
import com.pomzwj.trans.service.NotSupportService;
import com.pomzwj.trans.service.RequireNewService;
import com.pomzwj.trans.service.RequireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TransApplication.class)
public class TestApplication {
	@Autowired
	private RequireService requireService;
	@Autowired
	private RequireNewService requireNewService;
	@Autowired
	private NestedService nestedService;
	@Autowired
	private NotSupportService notSupportService;

	//PROPAGATION_REQUIRED
	//1.1场景一(此场景外围方法没有开启事务。)
	//1.1.1验证方法1
	@Transactional(propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_REQUIRED_1(){
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
	//1.1场景一(此场景外围方法没有开启事务。)
	//1.1.2验证方法2
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_REQUIRED_2(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(1);
		userInfo1.setName("zwj");

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setId(2);
		userInfo2.setName("zwk");

		requireService.addRequire(userInfo1);
		requireService.addRequireException(userInfo2);
	}
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_REQUIRED_3_try(){
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
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_REQUIRED_NEW_1(){

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
	@Commit
	@Test
	public void test_REQUIRED_NEW_2(){

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
	@Commit
	@Test
	public void test_REQUIRED_NEW_3(){

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
			System.out.println("异常");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_NESTED_1(){

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
	@Commit
	@Test
	public void test_NESTED_2(){

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
	@Commit
	@Test
	public void test_NESTED_3(){

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

	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_notSupport_1(){
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
	@Commit
	@Test
	public void test_notSupport_3(){
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
		try{
			notSupportService.addNotSupportException(userInfo2);
		}catch (Exception e){
			System.out.println("异常");
		}

	}
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
	@Commit
	@Test
	public void test_notSupport_4(){
		UserInfo userInfo0 = new UserInfo();
		userInfo0.setId(0);
		userInfo0.setName("zwh");

		notSupportService.addRequire2(userInfo0);
	}
}
