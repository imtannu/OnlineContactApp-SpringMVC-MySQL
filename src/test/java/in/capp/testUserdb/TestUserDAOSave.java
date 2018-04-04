package in.capp.testUserdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.capp.config.SpringRootConfig;
import in.capp.dao.UserDAO;
import in.capp.domain.User;

public class TestUserDAOSave {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("ganesh");
		u.setPhone("4444447383");
		u.setEmail("ganedh@hotmail.net");
		u.setAddress("fgfdd");
		u.setLoginName("fdeed");
		u.setPassword("ga1234");
		u.setRole(2);// Admin Role
		u.setLoginStatus(1); // Active
		userDAO.save(u);
		System.out.println("--------Data Saved------");

	}

}
