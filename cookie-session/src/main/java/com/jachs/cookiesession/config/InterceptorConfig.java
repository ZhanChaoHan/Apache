package com.jachs.cookiesession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jachs.cookiesession.interceptor.TestInterceptor;

/***
 * 
 * @author zhanchaohan
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Bean
	public TestInterceptor getMyInterceptor() {
		return new TestInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.getMyInterceptor()).addPathPatterns("/*")
		.excludePathPatterns("/aa/a");
	}
}
