package com.yesid.rpgcharacter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RpgCharacterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgCharacterApplication.class, args);
	}

}
