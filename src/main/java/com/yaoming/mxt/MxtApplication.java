package com.yaoming.mxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MxtApplication.class, args);
		
	}
	
	// 内置Tomcat设置
	@Bean
	public EmbeddedServletContainerFactory  servletContainer(){
		
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(80);
		
		return factory;
	}
}

