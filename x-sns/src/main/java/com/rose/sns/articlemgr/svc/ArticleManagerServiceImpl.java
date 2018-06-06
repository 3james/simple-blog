package com.rose.sns.articlemgr.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rose.sns.articlemgr.dao.ArticleManagerDAO;
import com.rose.sns.articlemgr.vo.ArticleManagerVO;

@Service
public class ArticleManagerServiceImpl implements ArticleManagerService {

	@Autowired
	private ArticleManagerDAO articleManagerDAO;
	
	
	@Override
	public ArticleManagerVO getArticle(String articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleManagerVO> getArticleList() {
		return articleManagerDAO.selectArticleList();
	}

	@Override
	public int createArticle(ArticleManagerVO articleManagerVO) {
		return articleManagerDAO.insertArticle(articleManagerVO);
	}

	@Override
	public int modifyArticle(ArticleManagerVO articleManagerVO) {
		return articleManagerDAO.updateArticle(articleManagerVO);
	}

	@Override
	public int removeArticle(String articleId) {
		return articleManagerDAO.deleteArticle(articleId);
	}

}
