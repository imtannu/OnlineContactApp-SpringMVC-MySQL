package in.capp.testUserdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.capp.config.SpringRootConfig;
import in.capp.dao.UserDAO;
import in.capp.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		ApplicationContext apx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = apx.getBean(UserDAO.class);
		User u = new User();
		
		u = userDAO.findById(4);

		System.out.println("User details..");
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getAddress());
		System.out.println(u.getLoginName());
		System.out.println(u.getPhone());

	}

}
