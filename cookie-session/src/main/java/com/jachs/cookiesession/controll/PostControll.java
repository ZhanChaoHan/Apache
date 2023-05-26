package com.jachs.cookiesession.controll;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		return "Post:"+boy.getName()+"\tgetB\t"+boy.getAge();
	}
	
    @PostMapping("/C")
    @ResponseBody
    public String postC(@Valid @RequestBody  Boy boy,BindingResult result) {
      //判断有没有异常错误,如果有则返回默认消息
        if (result.hasErrors()){
             String defaultMessage = result.getFieldError().getDefaultMessage();
             return defaultMessage;
         }
        return boy.toString ();
    }
    
    //加入这个全局异常处理不用接异常测试接口/D
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleValidException(MethodArgumentNotValidException e) {
        //将错误信息返回给前台
        return e.getBindingResult().getFieldError().getDefaultMessage();
    }
    
    @PostMapping("/D")
    @ResponseBody
    public String postD(@Valid @RequestBody  Boy boy) {
        return boy.toString ();
    }
}
