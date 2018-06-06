package com.rose.sns.articlemgr.svc;

import java.util.List;

import com.rose.sns.articlemgr.vo.ArticleManagerVO;

public interface ArticleManagerService {

	ArticleManagerVO getArticle(String articleId);
	
	List<ArticleManagerVO> getArticleList();
	
	int createArticle(ArticleManagerVO articleManagerVO);
	
	int modifyArticle(ArticleManagerVO articleManagerVO);
	
	int removeArticle(String articleId);
	
}
