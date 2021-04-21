package com.te.springmvc2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligationController {
	
	@GetMapping("/redirect")
	public  String redirectRequest() {
		return "redirect:https://youtube.com";
		
	}

}
