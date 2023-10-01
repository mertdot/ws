package com.businesscard.ws;

import com.businesscard.ws.user.User;
import com.businesscard.ws.user.UserRepository;
import com.businesscard.ws.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService){
		return (args) -> {
					User user = new User();
					user.setUsername("admin");
					user.setDisplayName("admin");
					user.setPassword("P4ssword");
					userService.save(user);
			};
	}

}