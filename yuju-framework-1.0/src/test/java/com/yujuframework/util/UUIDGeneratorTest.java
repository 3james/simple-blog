package com.yujuframework.util;

import org.junit.Test;

import com.yujuframework.util.UUIDGenerator;

public class UUIDGeneratorTest {

	@Test
	public void getIdTest() {
		String id = UUIDGenerator.getId();
		System.out.println(id);
	}
	
}
