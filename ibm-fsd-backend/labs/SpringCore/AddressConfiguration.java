package com.example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfiguration {

	@Bean
	public Address address() {
		return new Address("kolkata","India",700150);
	}
}
