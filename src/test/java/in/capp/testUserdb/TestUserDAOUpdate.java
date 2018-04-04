package in.capp.testUserdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.capp.config.SpringRootConfig;
import in.capp.dao.UserDAO;
import in.capp.domain.User;

public class TestUserDAOUpdate {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setUserId(4);
		u.setName("Akshay");
		u.setPhone("8600731036");
		u.setEmail("akki@gmail.com");
		u.setAddress("pune");
		u.setRole(1);// Admin Role
		u.setLoginStatus(1); // Active
		userDAO.update(u);
		System.out.println("--------Data Updated------");

	}

}
