package jachs.commons.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/**
 * @author zhanchaohan
 * 
 */
@RestController
public class HttpClientController {
    private Gson gson=new Gson();
    
    
	private Map<String, String[]> printHttpRequest(HttpServletRequest httpRequest) {
		Enumeration<String> enAttributeNames=httpRequest.getAttributeNames();
		while(enAttributeNames.hasMoreElements()) {
			String next=enAttributeNames.nextElement();
			
			System.out.println("参数:"+next+"\t\t"+httpRequest.getAttribute(next));
		}
		System.out.println("-------------------------------------------------------");
		Enumeration<String> enHeaderNames= httpRequest.getHeaderNames();
		while(enHeaderNames.hasMoreElements()) {
			String next=enHeaderNames.nextElement();
			
			System.out.println("标头:"+next+"\t\t"+httpRequest.getHeader(next));
		}
		System.out.println("-------------------------------------------------------");
		Enumeration<String> enParameterNames=httpRequest.getParameterNames();
		while(enParameterNames.hasMoreElements()) {
			String next=enParameterNames.nextElement();
			
			System.out.println("客户端传递参数:"+next+"\t\t"+httpRequest.getParameter(next));
		}
		return httpRequest.getParameterMap();
	}
	
    @PostMapping( "/postT1" )
    public String postT1 (HttpServletRequest request) {
        return "postT1"+gson.toJson(printHttpRequest(request));
    }
    @GetMapping( "/getT1" )
    public String getT1 (HttpServletRequest request) {
    	printHttpRequest(request);
        return "postT1"+gson.toJson(printHttpRequest(request));
    }
    @RequestMapping("/rm1")
    public String rm1(HttpServletRequest request) {
    	printHttpRequest(request);
        return "rm1"+gson.toJson(printHttpRequest(request));
    }
}
