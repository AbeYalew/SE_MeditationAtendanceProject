package edu.mum.cs.projects.attendance;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import edu.mum.cs.projects.attendance.domain.entity.Setup;
import edu.mum.cs.projects.attendance.repository.SetupRepository;
import edu.mum.cs.projects.attendance.service.UserService;


@SpringBootApplication
@PropertySource("production.properties")
public class ProductionApplication {
	public static void main(String[] args) {
		
		ApplicationContext context  =	SpringApplication.run(ProductionApplication.class, args);	
		
	}
}
