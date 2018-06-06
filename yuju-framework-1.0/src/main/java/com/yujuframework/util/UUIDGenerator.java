package com.yujuframework.util;

import java.util.UUID;

public class UUIDGenerator {
	
	public static String getId() {
		UUID idInteger = UUID.randomUUID();
		return idInteger.toString();
	}
	
}
