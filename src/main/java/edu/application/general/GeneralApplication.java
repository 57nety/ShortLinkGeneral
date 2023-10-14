package edu.application.general;

import edu.application.general.links.LinksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneralApplication.class, args);
	}

}
