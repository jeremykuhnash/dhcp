package com.jagornet.dhcp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JagornetBootApplication extends  SpringApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JagornetBootApplication.class);
		
	}

	@Autowired
	public JagornetDhcpServer server;
	
	public static void main(String[] args) {
		SpringApplication.run(JagornetBootApplication.class, args);
	}
}
