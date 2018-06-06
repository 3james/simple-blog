package com.rose.sns.usermgr.svc;

import java.util.List;

import com.rose.sns.usermgr.vo.UserManagerVO;

public interface UserManagerService {

	UserManagerVO getUser(String userId);
	
	List<UserManagerVO> getUserList();
	
	int createUser(UserManagerVO userMgrVO);
	
	int modifyUser(UserManagerVO userMgrVO);
	
	int removeUser(String userId);
	
}
