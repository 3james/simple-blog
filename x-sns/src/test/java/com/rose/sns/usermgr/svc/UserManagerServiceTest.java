package com.rose.sns.usermgr.svc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.rose.sns.usermgr.vo.UserManagerVO;

public class UserManagerServiceTest {

	private UserManagerService userMgrService;
	
	@SuppressWarnings("resource")
	@Before
	public void prepare() {
		ApplicationContext applicationContext = new GenericXmlApplicationContext("spring/*-context.xml");
		userMgrService = applicationContext.getBean(UserManagerServiceImpl.class);
	}
	
	@Test
	public void createUserTest() {
		UserManagerVO userMgrVO = new UserManagerVO();
		userMgrVO.setId("kimjames");
		userMgrVO.setName("KHK");
		userMgrVO.setAge("38");
		userMgrVO.setSex("M");
		userMgrService.createUser(userMgrVO);
	}
	
	@Test
	public void getUserTest() {
		UserManagerVO userMgrVO = new UserManagerVO();
		userMgrVO.setId("kimjames");
		UserManagerVO returnUserMgrVO = userMgrService.getUser("kimjames");
		System.out.println("He's name is " + returnUserMgrVO.getName());
	}	
	
}
