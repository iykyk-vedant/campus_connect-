package com.campusconnect.campusconnect;

import com.campusconnect.campusconnect.model.User;
import com.campusconnect.campusconnect.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class CampusconnectApplication {
	public static void main(String[] args) {
		SpringApplication.run(CampusconnectApplication.class, args);
	}

	@Bean
	CommandLineRunner initDefaultUser(UserRepository userRepo, PasswordEncoder encoder) {
		return args -> {
			userRepo.findByUsername("admin").ifPresentOrElse(
					u -> System.out.println("Default admin already exists."),
					() -> {
						User admin = new User();
						admin.setUsername("admin");
						admin.setPassword(encoder.encode("admin123"));
						admin.setRoles(List.of("ROLE_USER"));  // or ROLE_ADMIN if you prefer
						userRepo.save(admin);
						System.out.println("Created default user admin/admin123");
					}
			);
		};
	}
}
