package br.com.diolabs.clientbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientbotApplication.class, args);
	}

}
