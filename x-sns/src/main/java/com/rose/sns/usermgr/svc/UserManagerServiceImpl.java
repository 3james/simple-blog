package com.rose.sns.usermgr.svc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rose.sns.usermgr.dao.UserManagerDAO;
import com.rose.sns.usermgr.vo.UserManagerVO;

@Service
public class UserManagerServiceImpl implements UserManagerService {

	final static Logger logger = LoggerFactory.getLogger(UserManagerServiceImpl.class);
	
	@Autowired
	private UserManagerDAO userMgrDAO;
	
	@Override
	public UserManagerVO getUser(String userId) {
		return userMgrDAO.selectUser(userId);
	}

	@Override
	public List<UserManagerVO> getUserList() {
		return userMgrDAO.selectUserList();
	}

	@Override
	public int createUser(UserManagerVO userMgrVO) {
		logger.debug("In Create User Method !!!!");
		return userMgrDAO.insertUser(userMgrVO);
	}

	@Override
	public int modifyUser(UserManagerVO userMgrVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeUser(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
