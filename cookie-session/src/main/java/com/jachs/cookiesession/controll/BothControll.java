package com.jachs.cookiesession.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 
 * @author zhanchaohan
 *
 */
@Controller
@RequestMapping("/both")
public class BothControll {
	@RequestMapping("/A")
	@ResponseBody
	public String  postA(String pam1,String pam2) {
		return "Request:"+pam1+"\t:\t"+pam2;
	}
	
	@RequestMapping("/B")
	@ResponseBody
	public String getA(String pam1,String pam2) {
		return "Request:"+pam1+"\tgetA\t"+pam2;
	}
}
