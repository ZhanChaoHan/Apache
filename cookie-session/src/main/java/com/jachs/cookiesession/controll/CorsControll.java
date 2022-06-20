package com.jachs.cookiesession.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 
 * @author zhanchaohan
 *
 */
@Controller
public class CorsControll {
	
	@RequestMapping("/toCors")
	public String toCors() {
		return "Cors";
	}
}
