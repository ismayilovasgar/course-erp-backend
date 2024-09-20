package com.webperside.courseerpbackend;

import com.webperside.courseerpbackend.models.enums.user.UserStatus;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseErpBackendApplication  implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(CourseErpBackendApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user= User.builder()
				.name("asgar")
				.surname("ismayilov new ")
				.status(UserStatus.ACTIVE)
				.roleId(1L)
				.email("asgar@gmail.com")
				.phoneNumber("5685604")
				.password("1234")
				.build();

		userRepository.insert(user);
		System.out.printf("%s id user inserted%n",user.getId());
	}
}
