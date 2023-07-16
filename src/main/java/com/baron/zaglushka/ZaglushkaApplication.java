package com.baron.zaglushka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ZaglushkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaglushkaApplication.class, args);
		log.info("Emulator application started");
	}

}
