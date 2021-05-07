package com.pomzwj.trans;

import com.pomzwj.trans.facade.*;
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
	private RequireFacade requireFacade;
	@Autowired
	private RequireNewFacade requireNewFacade;
	@Autowired
	private NotSupportFacade notSupportFacade;
	@Autowired
	private NestedFacade nestedFacade;
	@Autowired
	private OtherFacade otherFacade;


	//1 REQUIRE
	@Test
	public void test_REQUIRED_1_1_1(){
		requireFacade.noTransRequire1();
	}
	@Test
	public void test_REQUIRED_1_1_2(){
		requireFacade.noTransRequire2();
	}

	@Test
	public void test_REQUIRED_1_2_1(){
		requireFacade.createTransRequire1();
	}
	@Test
	public void test_REQUIRED_1_2_2(){
		requireFacade.createTransRequire2();
	}
	@Test
	public void test_REQUIRED_1_2_3(){
		requireFacade.createTransRequire3_try();
	}


	//2.REQUIRE_NEW
	@Test
	public void test_REQUIRE_NEW_2_1_1(){
		requireNewFacade.noTransRequireNew1();
	}
	@Test
	public void test_REQUIRE_NEW_2_1_2(){
		requireNewFacade.noTransRequireNew2();
	}
	@Test
	public void test_REQUIRE_NEW_2_2_1(){
		requireNewFacade.createTransRequireNew1();
	}
	@Test
	public void test_REQUIRE_NEW_2_2_2(){
		requireNewFacade.createTransRequireNew2();
	}
	@Test
	public void test_REQUIRE_NEW_2_2_3(){
		requireNewFacade.createTransRequireNew3_try();
	}

	//3.not_support
	@Test
	public void test_NOT_SUPPOR_3_1_1(){
		notSupportFacade.noTransNotSupport1();
	}
	@Test
	public void test_NOT_SUPPORT_3_2_1(){
		notSupportFacade.createTransNotSupport1();
	}


	//4.NESTED
	@Test
	public void test_NESTED_3_1_1(){
		nestedFacade.noTransNested1();
	}
	@Test
	public void test_NESTED_3_1_2(){
		nestedFacade.noTransNested2();
	}
	@Test
	public void test_NESTED_3_2_1(){
		nestedFacade.createTransNested1();
	}
	@Test
	public void test_NESTED_3_2_2(){
		nestedFacade.createTransNested2();
	}
	@Test
	public void test_NESTED_3_2_3(){
		nestedFacade.createTransNested3_try();
	}

	//问题1
	@Test
	public void test_ServiceFork_1(){
		otherFacade.createTransServiceFork();
	}
}
