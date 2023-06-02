package com.skyscanner;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SkyscannerApplication {

	public static void main(String[] args) {

		SpringApplication.run(SkyscannerApplication.class, args);
	}
	  @Bean
      public ModelMapper modelMapper(){
		return new ModelMapper();
      }
}
