package com.a6.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.a6.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer  {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//		.order(1)
		.addPathPatterns("/*/*/*Xdm*", "/*/*/*User*")
		.excludePathPatterns(
//				"/resources/**",
				"/usr/**",
				"/xdm/adminlogin/adminLoginXdmForm",
				"/signinXdmProc",
				"/signoutXdmProc",
				"/user/userlogin/userLoginUserForm"
);
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
