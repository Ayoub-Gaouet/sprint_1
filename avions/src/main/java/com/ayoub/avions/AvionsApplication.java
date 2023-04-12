package com.ayoub.avions;

import com.ayoub.avions.entities.Avion;
import com.ayoub.avions.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AvionsApplication implements CommandLineRunner {
	@Autowired

	AvionService avionService;
	public static void main(String[] args) {
		SpringApplication.run(AvionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		avionService.saveAvion(new Avion("TU 216", 2600.0, new Date()));
		avionService.saveAvion(new Avion("TU 217", 2800.0, new Date()));
		avionService.saveAvion(new Avion("TU 218", 900.0, new Date()));
	}
}
