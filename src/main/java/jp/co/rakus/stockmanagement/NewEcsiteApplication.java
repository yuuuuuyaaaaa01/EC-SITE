package jp.co.rakus.stockmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NewEcsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewEcsiteApplication.class, args);
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	}
}
