package com.example.demo;

import com.example.demo.Entities.Student;
import com.example.demo.Respositories.StudentRepository;
import com.example.demo.Utilities.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(StudentRepository repository) {
		return (args) -> {
			// save a few students
			repository.save(new Student("Jessica", "Bauer", "11/09/2000", Gender.female, (long) 1));
			repository.save(new Student("Joshua", "Mokut", "11/06/1990", Gender.male, (long) 2));
			repository.save(new Student("Michael", "Effiong", "11/09/1997", Gender.male, (long) 2));
			repository.save(new Student("Sandra", "Okon", "11/09/1998", Gender.female, (long) 1));
			repository.save(new Student("Chima", "okoro", "12/07/1918", Gender.female, (long) 3));

			// fetch all students
			log.info("Students found with findAll():");
			log.info("-------------------------------");
			for (Student student : repository.findAll()) {
				log.info(student.toString());
			}
			log.info("");

			// fetch an individual student by ID
			Optional<Student> student = repository.findById(1L);
			log.info("Student found with findById(1L):");
			log.info("--------------------------------");
			log.info(student.toString());
			log.info("");

			// fetch students by last name
			log.info("Student found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findBySurname("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");



			log.info("Students found with groupid('1'):");
			log.info("--------------------------------------------");
			repository.findAllByGroupIdEquals(1L).forEach(student1 -> {
				log.info(student1.toString());
			});

			log.info("");
		};
	}
}
