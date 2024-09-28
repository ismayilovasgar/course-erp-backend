package com.webperside.courseerpbackend;

import com.webperside.courseerpbackend.models.enums.user.UserStatus;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.properties.security.SecurityProperties;
import com.webperside.courseerpbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@RequiredArgsConstructor
@SpringBootApplication
public class CourseErpBackendApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseErpBackendApplication.class, args);
	}

//	@Autowired
//	UserRepository userRepository;

//	@Override
//	public void run(String... args) throws Exception {
//		User user= User.builder()
//				.name("asgar")
//				.surname("ismayilov new ")
//				.status(UserStatus.ACTIVE)
//				.roleId(1L)
//				.email("asgar@gmail.com")
//				.phoneNumber("5685604")
//				.password("1234")
//				.build();
//
//		userRepository.insert(user);
//		System.out.printf("%s id user inserted%n",user.getId());
//	}


//	? Jwt Token Test -------------------------------------------------------------------------------------------
//	@Value("${security.jwt.public-key}")
//	private String publicKey;
//
//
//	@Value("${security.jwt.private-key}")
//	private String privateKey;

	private final SecurityProperties securityProperties;


	@Override
	public void run(String... args) throws Exception {
/*
		?Generate public and private key
		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
		keyGenerator.initialize(2048);
		KeyPair kp = keyGenerator.genKeyPair();
		PublicKey publicKey = kp.getPublic();
		PrivateKey privateKey = kp.getPrivate();

		String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

		System.out.println(convertToPublicKey(encodedPublicKey));
		System.out.println();
		System.out.println(convertToPrivateKey(encodedPrivateKey));
		?read keys with @Value annotation from yml file
		System.out.println(publicKey);
		System.out.println("-------------------------");
		System.out.println(privateKey);
*/


//		read keys with @configuration annotations
		System.out.println(securityProperties.getJwt().getAccessTokenValidityTime());

    }

	private static String convertToPrivateKey(String key) {
		StringBuilder result = new StringBuilder();
		result.append("-----BEGIN PRIVATE KEY-----\n");
		result.append(key);
		result.append("\n-----END PRIVATE KEY-----");
		return result.toString();
	}

	private static String convertToPublicKey(String key) {
		StringBuilder result = new StringBuilder();
		result.append("-----BEGIN PUBLIC KEY-----\n");
		result.append(key);
		result.append("\n-----END PUBLIC KEY-----");
		return result.toString();
	}
}
