package com.ohnong.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ohnong.app.**.mapper")
public class OhnongApplication {

	public static void main(String[] args) {
		SpringApplication.run(OhnongApplication.class, args);
	}

}
