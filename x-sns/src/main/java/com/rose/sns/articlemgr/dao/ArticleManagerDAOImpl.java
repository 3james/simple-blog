package com.rose.sns.articlemgr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rose.sns.articlemgr.vo.ArticleManagerVO;
import com.yujuframework.util.DateUtil;

@Repository
public class ArticleManagerDAOImpl implements ArticleManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArticleManagerVO selectArticle(String articleId) {
		ArticleManagerVO articleManagerVO = sqlSession.selectOne("com.rose.sns.articlemgr.dao.ArticleManagerDAO.selectArticle", articleId);
		return articleManagerVO;
	}

	@Override
	public List<ArticleManagerVO> selectArticleList() {
		List<ArticleManagerVO> articleManagerVOList = sqlSession.selectList("com.rose.sns.articlemgr.dao.ArticleManagerDAO.selectArticleList");
		return articleManagerVOList;
	}

	@Override
	public int insertArticle(ArticleManagerVO articleManagerVO) {
		return sqlSession.insert("com.rose.sns.articlemgr.dao.ArticleManagerDAO.insertArticle", articleManagerVO);
	}

	@Override
	public int updateArticle(ArticleManagerVO articleManagerVO) {
		return sqlSession.insert("com.rose.sns.articlemgr.dao.ArticleManagerDAO.updateArticle", articleManagerVO);
	}

	@Override
	public int deleteArticle(String articleId) {
		return sqlSession.delete("com.rose.sns.articlemgr.dao.ArticleManagerDAO.deleteArticle", articleId);
	}

}
