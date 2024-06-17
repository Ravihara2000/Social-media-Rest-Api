package com.SocialMedia.social_media_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SocialMediaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaBackendApplication.class, args);
	}

}
