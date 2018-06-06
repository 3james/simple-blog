package com.rose.sns.main.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/main/main.do")
	public String goMain() {
		return "main/main";
	}
	
	@RequestMapping(value="/main/common.do")
	public String goMainCommon() {
		return "common/common";
	}		
	
}
