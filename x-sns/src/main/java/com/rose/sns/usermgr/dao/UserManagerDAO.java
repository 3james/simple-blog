package com.rose.sns.usermgr.dao;

import java.util.List;

import com.rose.sns.usermgr.vo.UserManagerVO;

public interface UserManagerDAO {

	UserManagerVO selectUser(String userId);
	
	List<UserManagerVO> selectUserList();
	
	int insertUser(UserManagerVO userMgrVO);
	
	int updateUser(UserManagerVO userMgrVO);
	
	int deleteUser(String userId);
	
}
