package com.jagornet.dhcp.server;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jagornet.dhcp.Version;


@Configuration
public class Config {
	
	// trying to keep the original source 'rather clean' from Spring-isms... so this 
	// method is about the only easy way to let the app sense that its inside SpringBoot w/o 
	// coding any of it in Spring. 
	public static boolean springBootStrategy = false;
	
	@Bean
	public JagornetDhcpServer dhcpServer() {
		JagornetDhcpServer server = null;
		try {
			server = new JagornetDhcpServer(null);
            System.out.println("Starting Jagornet DHCP Server: " + new Date());
            System.out.println(Version.getVersion());
            server.start();
        }
        catch (Exception ex) {
            System.err.println("DhcpServer ABORT!");
            ex.printStackTrace();
            System.exit(1);
        }
		springBootStrategy = true;
		return server;
	}
}
