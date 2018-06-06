package com.rose.sns.articlemgr.dao;

import java.util.List;

import com.rose.sns.articlemgr.vo.ArticleManagerVO;

public interface ArticleManagerDAO {

	ArticleManagerVO selectArticle(String articleId);
	
	List<ArticleManagerVO> selectArticleList();
	
	int insertArticle(ArticleManagerVO articleManagerVO);
	
	int updateArticle(ArticleManagerVO articleManagerVO);
	
	int deleteArticle(String articleId);
	
}
