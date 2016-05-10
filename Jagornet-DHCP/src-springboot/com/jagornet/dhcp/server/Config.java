package com.jagornet.dhcp.server;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jagornet.dhcp.Version;


@Configuration
public class Config {
	
	
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
		JagornetDhcpServer.springBootStrategy = true;
		return server;
	}
}
