package com.rose.sns.comm.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.rose.sns.comm.util.PropertyUtil;

@Controller
public class SmartEditorFileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(SmartEditorFileUploadController.class);
	
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	
	@RequestMapping(value="/comm/fileupload/fileUploadForSmartEditor.upload", method=RequestMethod.POST)
	public ModelAndView fileUploadForSmartEditor(MultipartHttpServletRequest mRequest) {
		
		ModelAndView returnModel = new ModelAndView("ajaxSmartEditorUploadResponseView");
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("SmartEditorFileUploadController Started !!");
    	}
    	
    	String filePathUploadBase = PropertyUtil.getValue("smart.editor.file.upload.base.dir");
    	String filePathUploadRelative = PropertyUtil.getValue("smart.editor.file.upload.relative.dir");
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("smart.editor.file.upload.base.dir" + filePathUploadBase);
    		logger.debug("smart.editor.file.upload.relative.dir" + filePathUploadRelative);
    	}

    	Iterator<String> fileNames = mRequest.getFileNames();
    	MultipartFile file = mRequest.getFile(fileNames.next());
    	String fileName = file.getOriginalFilename();
    	String fileDirPath = filePathUploadBase + FILE_SEPARATOR + filePathUploadRelative;
    	String fullFilePath = fileDirPath + FILE_SEPARATOR + fileName;

    	FileOutputStream fileOutputStream = null ;

    	try {

    		byte[] bytes = file.getBytes();

    		if (logger.isDebugEnabled()) {
    			logger.debug("fileDirPath : " + fileDirPath);
    			logger.debug("fullFilePath : " + fullFilePath);
    		}
    		File fileDir = new File(fileDirPath);
    		if (!fileDir.isDirectory()) {
    			fileDir.mkdirs();
    			if (logger.isDebugEnabled()) {
    				logger.debug(fileDirPath + " directory created");
    			}
    		}  
    		File outFile = new File(fullFilePath);
    		fileOutputStream = new FileOutputStream(outFile);
    		fileOutputStream.write(bytes);

    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} finally {
    		try{
    			if (fileOutputStream != null) {
    				fileOutputStream.close();
    			}
    		} catch (IOException ioe) {
    			// TODO Auto-generated catch block
    			ioe.printStackTrace();
    		}
    	}

    	FileInfo fileInfo = new FileInfo();
    	fileInfo.setFileName(fileName);
    	fileInfo.setFilePath(fullFilePath);
        
    	returnModel.addObject("fileInfo", fileInfo);
    	
    	if (logger.isDebugEnabled()) {
    		logger.debug("SmartEditorFileUploadController Ended !!");
    	}    	
		
		return returnModel;
	}	
	
}
