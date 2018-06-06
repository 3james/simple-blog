package com.yujuframework.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static String getDateTimeMilisec() {
		ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
		ZonedDateTime zonedDateTime = ZonedDateTime.now(seoulZoneId);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		return zonedDateTime.format(dateTimeFormatter);
	}
	
}
