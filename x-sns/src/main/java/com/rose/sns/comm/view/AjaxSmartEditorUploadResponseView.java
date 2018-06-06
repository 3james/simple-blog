package com.rose.sns.comm.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.rose.sns.comm.fileupload.FileInfo;
import com.rose.sns.comm.util.PropertyUtil;


public class AjaxSmartEditorUploadResponseView extends AbstractView{

	private static final Logger logger = LoggerFactory.getLogger(AjaxSmartEditorUploadResponseView.class) ;
	
	private static final String FILE_UPLOAD_WEB_DIR = PropertyUtil.getValue("smart.editor.file.upload.web.dir");
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String IMAGE_WIDTH = PropertyUtil.getValue("smart.editor.image.width");
	private static final String IMAGE_HEIGHT = PropertyUtil.getValue("smart.editor.image.height");
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FileInfo fileInfo = (FileInfo)model.get("fileInfo");
		
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("bNewLine=").append("true");
		stringBuffer.append("&sFileName=").append(fileInfo.getFileName());
		stringBuffer.append("&sFileURL=").append(FILE_UPLOAD_WEB_DIR)
		                                            .append(FILE_SEPARATOR)
		                                            .append(fileInfo.getFileName());
		stringBuffer.append("&width=").append(IMAGE_WIDTH);
		stringBuffer.append("&height=").append(IMAGE_HEIGHT);
		
		if (logger.isDebugEnabled()) {
			logger.debug(stringBuffer.toString());
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentLength(stringBuffer.toString().getBytes("utf-8").length);
		response.getWriter().print(stringBuffer.toString());
		
	}

}
