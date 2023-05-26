package com.jachs.cookiesession.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
public class Boy {
    @NotNull(message = "名称不能为空")
	private String name;
    
    @Min(value = 1,message = "最小不能小于1")
    @Max(value = 99,message ="最大不能大于99")
	private int age;
    
    @Email ( message = "输入邮箱不合法" )
	private String email;
	
	@URL(message = "输入URL不合法")
	private String url;
	
	@Pattern(regexp = "[abc]",message = "不符合正则表达式[abc]")
	private String pattern;

    @Override
    public String toString () {
        return "Boy [name=" + name + ", age=" + age + ", email=" + email + ", url=" + url + ", pattern=" + pattern
                + "]";
    }
	
}
