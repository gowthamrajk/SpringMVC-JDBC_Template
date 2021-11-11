package com.gowthamrajk.dashboard;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gowthamrajk.model.User;
import com.gowthamrajk.service.UserService;

public class UserDashboard {

	public static void main(String[] args) {
		
		ApplicationContext contextObj = new ClassPathXmlApplicationContext("spring-jdbcDB-config.xml");  
		
		UserService serviceObj = contextObj.getBean("userService", UserService.class);
		
		User userObj1 = contextObj.getBean("user1", User.class);
		serviceObj.saveUser(userObj1);		
		serviceObj.saveUser(contextObj.getBean("user2", User.class));
		
		System.out.println("\nAfter Inserting New User : \n");
		for(User userObj : serviceObj.getAllUser()) {
			System.out.println(userObj);
		}
		
		serviceObj.updateUser(new User(101, "gowthamraj", "gowthamraj@gmail.com", 1234567891, "1234"));
		
		System.out.println("\nAfter Updating User : \n");
		for(User userObj : serviceObj.getAllUser()) {
			System.out.println(userObj);
		}
		
		serviceObj.deleteUser(contextObj.getBean("user2", User.class));
		
		System.out.println("\nAfter Deleting New User : \n");
		for(User userObj : serviceObj.getAllUser()) {
			System.out.println(userObj);
		}
		
		System.out.print("\nGet User by ID\n");
		for(User userObj : serviceObj.getUserById(101)) {
			System.out.println(userObj);
		}		
	}
}
