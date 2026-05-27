package io.github.handmadeapp.taskflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskflowApplication.class, args);
	}
//Code below ist just for the test perpose

//	@Bean
//	public CommandLineRunner commandLineRunner(UserDAO appDAO)
//	{
//		return runner -> createUserWithTasks(appDAO);
//	}

//	private void createUserWithTasks(UserDAO appDAO)
//	{
//		User tempUser = new User("Jan Kowalski", "jkowalski@gmail.com", "abcd", Role.USER, true);
//
//		Task tempTask = new Task("Fix login bug",
//     										"Investigate authentication problem",
//     															TaskStatus.TODO,
//														 			Priority.HIGH,
//     															LocalDateTime.now().plusDays(3)
//		);
//
//		Task tempTask2 = new Task("Fix backend bug",
//		                         "Delete unused code",
//		                         TaskStatus.TODO,
//		                         Priority.HIGH,
//		                         LocalDateTime.now().plusDays(5)
//		);
//
//		tempUser.addTask(tempTask);
//		tempUser.addTask(tempTask2);
//
//		appDAO.saveUser(tempUser);
//
//	}

}
