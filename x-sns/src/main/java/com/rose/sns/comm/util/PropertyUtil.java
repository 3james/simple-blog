package com.rose.sns.comm.util;

import java.util.ResourceBundle;

import com.rose.sns.comm.constant.CommonConstants;

public class PropertyUtil {

	private static ResourceBundle resourceBundle;
	
	static {
		resourceBundle = ResourceBundle.getBundle(CommonConstants.DEFAULT_PROPERTY_FILE);
	}
	
	public static String getValue(String key) {
		return resourceBundle.getString(key);
	}
	
}
