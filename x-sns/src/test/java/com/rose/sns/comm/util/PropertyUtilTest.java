package com.rose.sns.comm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import com.rose.sns.comm.util.PropertyUtil;

public class PropertyUtilTest {

	@Before
	public void prepare() {
//		ApplicationContext applicationContext = new GenericXmlApplicationContext("spring/*-context.xml");
	}
	
	@Test
	public void test1() {
		ResourceBundle rb = ResourceBundle.getBundle("properties/xsns");
		System.out.println(rb.getString("file.path.upload.base"));
	}	
	
	@Test
	public void test2() throws IOException {
		Properties properties = new Properties();
		String propertyFileName = "properties/xsns.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
		properties.load(inputStream);
		System.out.println(PropertyUtil.getValue("file.path.upload.base"));
	}
	
	@Test
	public void test3() {
		System.out.println(PropertyUtil.getValue("file.path.upload.base"));
	}
	
}
