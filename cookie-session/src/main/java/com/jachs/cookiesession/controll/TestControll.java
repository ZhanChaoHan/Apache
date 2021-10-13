package com.jachs.cookiesession.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 
 * @author zhanchaohan
 *
 */
@Controller
@RequestMapping("/test")
public class TestControll {
	
	@PostMapping("/posta")
	@ResponseBody
	public String  postA(String pam1,String pam2) {
		return pam1+"\t:\t"+pam2;
	}
	
	@GetMapping("/geta")
	@ResponseBody
	public String getA(String pam1,String pam2) {
		return pam1+"\tgetA\t"+pam2;
	}
}
