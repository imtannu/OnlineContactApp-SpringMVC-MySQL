package in.capp.testUserdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.capp.config.SpringRootConfig;
import in.capp.dao.UserDAO;
import in.capp.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		ApplicationContext apx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = apx.getBean(UserDAO.class);
		User u = new User();
		u.setUserId(7);
		userDAO.delete(u);

		System.out.println("User Deleted..");

	}

}
