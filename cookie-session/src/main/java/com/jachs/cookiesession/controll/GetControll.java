package com.jachs.cookiesession.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 
 * @author zhanchaohan
 *
 */
@Controller
@RequestMapping("/get")
public class GetControll {
	
	@GetMapping("/A")
	@ResponseBody
	public String  postA(String pam1,String pam2) {
		return "Get:"+pam1+"\t:\t"+pam2;
	}
	
	@GetMapping("/B")
	@ResponseBody
	public String getA(String pam1,String pam2) {
		return "Get:"+pam1+"\tgetA\t"+pam2;
	}
}
