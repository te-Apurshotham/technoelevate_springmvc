package com.te.springmvc2.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;


public class CookieController {
	
	@GetMapping("/cookiesPage")
	public String getCookies() {
		return "cookiesPage";
		
	}
	
	@GetMapping("/cookiesPage")
	public String name(HttpServletResponse respone,ModelMap map) {
		Cookie cookie = new Cookie("Empname", "Sai");
		respone.addCookie(cookie);
		map.addAttribute("msg", "created cookies");
		return "cookiesPage";
		
	}
	
	@GetMapping()
	public String showCookies(@CookieValue(name = "EmpName") String name, ModelMap map) {
		return name;
		
	}
	
	

}
