package site.metacoding.timetabletest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TimetabletestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetabletestApplication.class, args);
	}

}
