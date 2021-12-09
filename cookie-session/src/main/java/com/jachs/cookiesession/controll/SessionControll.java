package com.jachs.cookiesession.controll;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 
 * @author zhanchaohan
 *
 */
@Controller
@RequestMapping("/session")
public class SessionControll {
	
	@RequestMapping("/createCookie")
	@ResponseBody
	public String createCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie ck=new Cookie("jachs", "testCookie");
		response.addCookie(ck);
		return "createCookie";
	}
	@PostMapping("/login")
	@ResponseBody
	public String login(HttpServletResponse response,String user,String password) {
		Cookie ck=new Cookie(user, password);
//		ck.setMaxAge(5000);
		response.addCookie(ck);
		return "login";
	}
	
	@RequestMapping("/readAllCookie")
	@ResponseBody
	public String readAllCookie(HttpServletRequest request, HttpServletResponse response) {
//		response.setHeader("", "");
		Cookie [] ck=request.getCookies();
		if(ck!=null) {
			for (Cookie cookie : ck) {
				System.out.println(cookie.getName());
			}
		}
		return "readAllCookie";
	}
	@RequestMapping("/deleteCookie")
	@ResponseBody
	public void deleteCookie(HttpServletRequest request) {
		Cookie [] ck=request.getCookies();
		for (Cookie cookie : ck) {
			cookie.setMaxAge(-1);
		}
	}
}
