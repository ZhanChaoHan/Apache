package com.jachs.cookiesession.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jachs.cookiesession.entity.Boy;

/***
 * 
 * @author zhanchaohan
 *
 */
@Controller
@RequestMapping("/post")
public class PostControll {
	
	@PostMapping("/A")
	@ResponseBody
	public String  postA(String pam1,String pam2) {
		return "Post:"+pam1+"\t:\t"+pam2;
	}
	
	@PostMapping("/B")
	@ResponseBody
	public String postB(@RequestBody  Boy boy) {
		return "Post:"+boy.getName()+"\tgetA\t"+boy.getAge();
	}
}
