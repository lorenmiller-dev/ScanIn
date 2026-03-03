package io.github.lorenmiller_dev.tap_in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TapInApplication {

	public static void main(String[] args) {
		SpringApplication.run(TapInApplication.class, args);
		System.out.println("TapInApplication started");
	}
}
