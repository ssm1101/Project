package com.ohnong.app.common.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry	
		.addResourceHandler("/home/ubuntu/etc/**")
			// 이미지 파일을 불러올 저장소의 위치를 지정한다.
        .addResourceLocations("file:///etc/");
	}
}