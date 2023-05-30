package com.ohnong.app.journal.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig_2  implements WebMvcConfigurer{

	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/home/ubuntu/etc/**")
	                .addResourceLocations("file:///etc/");
	    }
}
