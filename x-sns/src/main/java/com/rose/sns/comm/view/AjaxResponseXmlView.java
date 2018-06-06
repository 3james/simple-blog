package com.rose.sns.comm.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.rose.sns.comm.fileupload.FileInfo;


public class AjaxResponseXmlView extends AbstractView{

	private static final Logger logger = LoggerFactory.getLogger(AjaxResponseXmlView.class) ;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<FileInfo> fileInfoList = (List<FileInfo>)model.get("fileInfoList");
		
		String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n";
		
		StringBuffer xmlSb = new StringBuffer();
		xmlSb.append(xmlHeader);
		
		xmlSb.append("<data>");
		if (fileInfoList != null) {
			for (int i = 0; i < fileInfoList.size(); i++) {
				xmlSb.append("<file>");
				xmlSb.append("<fileName>");
				xmlSb.append(fileInfoList.get(i).getFileName());
				xmlSb.append("</fileName>");
				xmlSb.append("<filePath>");
				xmlSb.append(fileInfoList.get(i).getFilePath());
				xmlSb.append("</filePath>");
				xmlSb.append("</file>");
			}
		}
		xmlSb.append("</data>");
		
		if (logger.isDebugEnabled()) {
			logger.debug(xmlSb.toString());
		}
		
		response.setContentType("application/xml");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentLength(xmlSb.toString().getBytes("utf-8").length);
		response.getWriter().print(xmlSb.toString());
		
	}

	

}
