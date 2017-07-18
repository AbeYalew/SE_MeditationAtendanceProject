package edu.mum.cs.projects.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
<<<<<<< HEAD

import edu.mum.cs.projects.attendance.service.UserService;

//@SpringBootApplication

=======
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import edu.mum.cs.projects.attendance.service.UserService;

@SpringBootApplication
>>>>>>> c8dab2afa15303b18f9823cc30d8fffc44757944
public class CreateUsers {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CreateUsers.class, args);

		UserService service = context.getBean(UserService.class);
		service.creatUsers();
		System.exit(0);
	}

}
