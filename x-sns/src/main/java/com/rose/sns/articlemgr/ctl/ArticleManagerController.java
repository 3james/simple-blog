package com.rose.sns.articlemgr.ctl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rose.sns.articlemgr.svc.ArticleManagerService;
import com.rose.sns.articlemgr.vo.ArticleManagerVO;
import com.yujuframework.util.DateUtil;
import com.yujuframework.util.UUIDGenerator;

@Controller
public class ArticleManagerController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleManagerController.class);
	
	@Autowired
	private ArticleManagerService articleManagerService;

	
	@RequestMapping(value = "/articlemgr/createarticle.ajax", method = RequestMethod.POST)
	public ModelAndView createArticle(HttpServletRequest request) {
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Create Article Started !!");
    	}
    	
    	String articleId = UUIDGenerator.getId();
    	String articleContent = request.getParameter("articleContent");
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("articleContent : " + articleContent);
    	}
    	
    	ArticleManagerVO articleManagerVO = new ArticleManagerVO();
    	articleManagerVO.setArticleId(articleId);
    	articleManagerVO.setContent(articleContent);
    	articleManagerVO.setCreateDate(DateUtil.getDateTimeMilisec());
    	
    	articleManagerService.createArticle(articleManagerVO);
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("Create Article Ended !!");
    	}
    	
		return new ModelAndView("jsonView");
	}
	
	@RequestMapping(value = "/articlemgr/modifyarticle.ajax", method = RequestMethod.POST)
	public ModelAndView modifyArticle(HttpServletRequest request) {
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Update Article Started !!");
    	}
    	
    	String articleId = request.getParameter("articleId");
    	String articleContent = request.getParameter("articleContent");
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("articleId : " + articleId);
    		logger.debug("articleContent : " + articleContent);
    	}
    	
    	ArticleManagerVO articleManagerVO = new ArticleManagerVO();
    	articleManagerVO.setArticleId(articleId);
    	articleManagerVO.setContent(articleContent);
    	articleManagerVO.setModifyDate(DateUtil.getDateTimeMilisec());
    	
    	articleManagerService.modifyArticle(articleManagerVO);
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("Update Article Ended !!");
    	}
    	
		return new ModelAndView("jsonView");
	}	
	
	@RequestMapping(value = "/articlemgr/removearticle.ajax", method = RequestMethod.POST)
	public ModelAndView removeArticle(HttpServletRequest request) {
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Remove Article Started !!");
    	}
    	
    	String articleId = request.getParameter("articleId");
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("Remove ArticleId : " + articleId);
    	}
    	
    	ArticleManagerVO articleManagerVO = new ArticleManagerVO();
    	articleManagerVO.setArticleId(articleId);
    	
    	articleManagerService.removeArticle(articleId);
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("Remove Article  Ended !!");
    	}
    	
		return new ModelAndView("jsonView");
	}	
	
	@RequestMapping(value = "/articlemgr/getarticlelist.ajax", method = RequestMethod.POST)
	public ModelAndView getArticleList() {
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Get Article List Started !!");
    	}
		
		List<ArticleManagerVO> articleList = articleManagerService.getArticleList();
		for (ArticleManagerVO vo: articleList) {
			if (logger.isDebugEnabled()) {
				logger.debug(vo.getCreateDate());
				logger.debug(vo.getArticleId());
				logger.debug(vo.getContent());
			}
		}
		
		ModelAndView modelAndView = new ModelAndView("jsonView");
		modelAndView.addObject("articleList", articleList);
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Get Article List Ended !!");
    	}		
		
		return modelAndView; 
	}
	
}
