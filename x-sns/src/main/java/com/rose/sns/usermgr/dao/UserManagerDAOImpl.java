package com.rose.sns.usermgr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rose.sns.usermgr.vo.UserManagerVO;

@Repository
public class UserManagerDAOImpl implements UserManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserManagerVO selectUser(String userId) {
		UserManagerVO userMgrVO = sqlSession.selectOne("com.rose.sns.usermgr.dao.UserMgrDAO.selectUser", userId);
		return userMgrVO;
	}

	@Override
	public List<UserManagerVO> selectUserList() {
		List<UserManagerVO> userMgrVOList = sqlSession.selectList("com.rose.sns.usermgr.dao.UserMgrDAO.selectUserList");
		return userMgrVOList;
	}

	@Override
	public int insertUser(UserManagerVO userMgrVO) {
		return sqlSession.insert("com.rose.sns.usermgr.dao.UserMgrDAO.insertUser", userMgrVO);
	}

	@Override
	public int updateUser(UserManagerVO userMgrVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
